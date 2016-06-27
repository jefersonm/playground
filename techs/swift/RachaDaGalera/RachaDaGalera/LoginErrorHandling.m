//
//  LoginErrorHandling.m
//  RachaDaGalera
//
//  Created by Jéferson Machado on 07/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "LoginErrorHandling.h"

@implementation LoginErrorHandling

- (void)loginView:(FBLoginView *)loginView handleError:(NSError *)error {
	NSString *alertMessage, *alertTitle;
	
	if ([FBErrorUtility shouldNotifyUserForError:error]) {
		alertTitle = @"Facebook error";
		alertMessage = [FBErrorUtility userMessageForError:error];
	} else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryAuthenticationReopenSession) {
		alertTitle = @"Session Error";
		alertMessage = @"Your current session is no longer valid. Please log in again.";
	} else if ([FBErrorUtility errorCategoryForError:error] == FBErrorCategoryUserCancelled) {
		NSLog(@"user cancelled login");
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