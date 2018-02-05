//
//  FacebookController.m
//  RachaDaGalera
//
//  Created by Jéferson Machado on 08/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <FacebookSDK/FacebookSDK.h>
#import "FacebookController.h"

@interface FacebookController ()<FBLoginViewDelegate, FBFriendPickerDelegate, UISearchBarDelegate>

@property (weak, nonatomic) IBOutlet FBLoginView *loginView;
@property (retain, nonatomic) FBFriendPickerViewController *friendPickerController;
@property (retain, nonatomic) UISearchBar *searchBar;
@property (retain, nonatomic) NSString *searchText;
@property (retain, nonatomic) NSMutableArray *baladeiros;
@property (weak, nonatomic) IBOutlet UITableView *tableView;
@property (weak, nonatomic) IBOutlet UITextField *valorTotal;


@end

@implementation FacebookController
id<FBGraphUser> cachedUser;

#pragma mark - Helper methods

/*
 * Method to dismiss the friend selector
 */
- (void) handlePickerDone
{
	[self dismissViewControllerAnimated:YES completion:nil];
}

/*
 * Method to add the search bar to the friend picker
 */
- (void)addSearchBarToFriendPickerView
{
	if (self.searchBar == nil) {
		CGFloat searchBarHeight = 44.0;
		self.searchBar =
		[[UISearchBar alloc]
		 initWithFrame:
		 CGRectMake(0,0,
					self.view.bounds.size.width,
					searchBarHeight)];
		self.searchBar.autoresizingMask = self.searchBar.autoresizingMask |
		UIViewAutoresizingFlexibleWidth;
		self.searchBar.delegate = self;
		self.searchBar.showsCancelButton = YES;
		
		[self.friendPickerController.canvasView addSubview:self.searchBar];
		CGRect newFrame = self.friendPickerController.view.bounds;
		newFrame.size.height -= searchBarHeight;
		newFrame.origin.y = searchBarHeight;
		self.friendPickerController.tableView.frame = newFrame;
	}
}

/*
 * Method to dismiss the keyboard, set the search query, and
 * trigger the search by updating the friend picker view.
 */
- (void) handleSearch:(UISearchBar *)searchBar {
	[searchBar resignFirstResponder];
	self.searchText = searchBar.text;
	[self.friendPickerController updateView];
}

#pragma mark - View lifecycle

- (void)viewDidLoad
{
	[super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
	_baladeiros = [[NSMutableArray alloc]init];
	
	// Ask for the required permissions
	FBLoginView *loginView = [[FBLoginView alloc] init];
	loginView.frame = CGRectOffset(loginView.frame, 50, 450);
	loginView.readPermissions = @[@"public_profile", @"email", @"user_friends"];
	loginView.delegate = self;
	[self.view addSubview:loginView];
	[loginView sizeToFit];
}

- (void)viewDidUnload
{
//	[self setSelectFriendsButton:nil];
	[super viewDidUnload];
	// Release any retained subviews of the main view.
	
	self.friendPickerController = nil;
	self.searchBar = nil;
}

-(void)requestFriends {
	FBRequest *friendsRequest = [FBRequest requestForMyFriends];
	NSMutableArray *arrayAmigos =[[NSMutableArray alloc]init];
	
	[friendsRequest startWithCompletionHandler:^(FBRequestConnection *connection, id result, NSError *err) {
		
		
		if (err)
		{
			NSLog(@"%i",(int)err.code);
		}
		else
		{
			NSSortDescriptor *sortDescriptor = [[NSSortDescriptor alloc] initWithKey: @"name" ascending: YES];
			[arrayAmigos addObjectsFromArray:[[result objectForKey:@"data"] sortedArrayUsingDescriptors:[NSArray arrayWithObject:sortDescriptor]]];
		}
	}];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
	return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

#pragma mark - Action methods

- (IBAction)selectFriendsButtonAction:(id)sender withController:(FBViewController*)controller {
	if (self.friendPickerController == nil) {
		// Create friend picker, and get data loaded into it.
		self.friendPickerController = [[FBFriendPickerViewController alloc] init];
		self.friendPickerController.title = @"Select Friends";
		self.friendPickerController.delegate = controller;
	}
	[self.friendPickerController loadData];
	[self.friendPickerController clearSelection];
	
	// Present the friend picker
	[self presentViewController:self.friendPickerController
					   animated:YES
					 completion:^(void){
						 [self addSearchBarToFriendPickerView];
					 }
	 ];
}

#pragma mark - FBFriendPickerDelegate methods
- (void)facebookViewControllerCancelWasPressed:(id)sender
{
	[self handlePickerDone];
}

- (void)facebookViewControllerDoneWasPressed:(id)sender
{
	for (id<FBGraphUser> user in self.friendPickerController.selection) {
		[self.baladeiros addObject:user];
	}
	[_tableView reloadData];
	[self handlePickerDone];
}

/*
 * This delegate method is called to decide whether to show a user
 * in the friend picker list.
 */
- (BOOL)friendPickerViewController:(FBFriendPickerViewController *)friendPicker
				 shouldIncludeUser:(id<FBGraphUser>)user
{
	// If there is a search query, filter the friend list based on this.
	if (self.searchText && ![self.searchText isEqualToString:@""]) {
		NSRange result = [user.name
						  rangeOfString:self.searchText
						  options:NSCaseInsensitiveSearch];
		if (result.location != NSNotFound) {
			// If friend name matches partially, show the friend
			return YES;
		} else {
			// If no match, do not show the friend
			return NO;
		}
	} else {
		// If there is no search query, show all friends.
		return YES;
	}
	return YES;
}

#pragma mark - UISearchBarDelegate methods
- (void)searchBarSearchButtonClicked:(UISearchBar*)searchBar
{
	// Trigger the search
	[self handleSearch:searchBar];
}

- (void)searchBarCancelButtonClicked:(UISearchBar *) searchBar {
	// Clear the search query and dismiss the keyboard
	self.searchText = nil;
	[searchBar resignFirstResponder];
}


#pragma mark Table View Data Source

- (NSInteger) numberOfSectionsInTableView:(UITableView *)tableView
{
	return 1;
}

- (NSInteger) tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
	return _baladeiros.count;
}



@end
