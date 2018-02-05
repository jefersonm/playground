//
//  LoginUIViewController.m
//  FaceIntegrationObjc
//
//  Created by Jéferson Machado on 05/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import "LoginUIViewController.h"

@interface LoginUIViewController ()
@property (strong, nonatomic) IBOutlet FBProfilePictureView *profilePictureView;
@property (strong, nonatomic) IBOutlet UILabel *nameLabel;
@property (strong, nonatomic) IBOutlet UILabel *statusLabel;
@end

@implementation LoginUIViewController

- (void)viewDidLoad
{
	[super viewDidLoad];
	
    [FBProfilePictureView class];
	
	// Ask for the required permissions
	FBLoginView *loginView = [[FBLoginView alloc] init];
	loginView.frame = CGRectOffset(loginView.frame, 50, 450);
	loginView.readPermissions = @[@"public_profile", @"email", @"user_friends"];
	loginView.delegate = self;
	[self.view addSubview:loginView];
	[loginView sizeToFit];
}

// This method will be called when the user information has been fetched
- (void)loginViewFetchedUserInfo:(FBLoginView *)loginView user:(id<FBGraphUser>)user {
	self.profilePictureView.profileID = user.id;
	self.nameLabel.text = user.name;
}

// Implement the loginViewShowingLoggedInUser: delegate method to modify your app's UI for a logged-in user experience
- (void)loginViewShowingLoggedInUser:(FBLoginView *)loginView {
	self.statusLabel.text = @"You're logged in as";
}

// Implement the loginViewShowingLoggedOutUser: delegate method to modify your app's UI for a logged-out user experience
- (void)loginViewShowingLoggedOutUser:(FBLoginView *)loginView {
	self.profilePictureView.profileID = nil;
	self.nameLabel.text = @"";
	self.statusLabel.text= @"You're not logged in!";
}

// You need to override loginView:handleError in order to handle possible errors that can occur during login
- (void)loginView:(FBLoginView *)loginView handleError:(NSError *)error {
	NSString *alertMessage, *alertTitle;
	
	// If the user should perform an action outside of you app to recover,
	// the SDK will provide a message for the user, you just need to surface it.
	// This conveniently handles cases like Facebook password change or unverified Facebook accounts.
	if ([FBErrorUtility shouldNotifyUserForError:error]) {
		alertTitle = @"Facebook error";
		alertMessage = [FBErrorUtility userMessageForError:error];
  
  // This code will handle session closures since that happen outside of the app.
  // You can take a look at our error handling guide to know more about it
  // https://developers.facebook.com/docs/ios/errors
	} else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryAuthenticationReopenSession) {
		alertTitle = @"Session Error";
		alertMessage = @"Your current session is no longer valid. Please log in again.";
		
		// If the user has cancelled a login, we will do nothing.
		// You can also choose to show the user a message if cancelling login will result in
		// the user not being able to complete a task they had initiated in your app
		// (like accessing FB-stored information or posting to Facebook)
	} else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryUserCancelled) {
		NSLog(@"user cancelled login");
		
		// For simplicity, this sample handles other errors with a generic message
		// You can checkout our error handling guide for more detailed information
		// https://developers.facebook.com/docs/ios/errors
	} else {
		alertTitle  = @"Something went wrong";
		alertMessage = @"Please try again later.";
		NSLog(@"Unexpected error:%@", error);
	}
	
	if (alertMessage) {
		[[[UIAlertView alloc] initWithTitle:alertTitle
									message:alertMessage
								   delegate:nil
						  cancelButtonTitle:@"OK"
						  otherButtonTitles:nil] show];
	}
}

@end