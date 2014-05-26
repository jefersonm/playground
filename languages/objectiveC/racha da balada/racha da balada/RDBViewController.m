//
//  RDBViewController.m
//  Racha da Balada
//
//  Created by Rafael Sperling on 1/6/14.
//  Copyright (c) 2014 Rafael Sperling. All rights reserved.
//


#import "RDBViewController.h"
#import "RDBGastoViewController.h"
#import "AsyncImageView.h"
#import <FacebookSDK/FacebookSDK.h>
#import "RDBBaladeiro.h"
#import <QuartzCore/QuartzCore.h>


@interface RDBViewController ()<FBLoginViewDelegate, FBFriendPickerDelegate, UISearchBarDelegate>

@property (weak, nonatomic) IBOutlet FBLoginView *loginView;
@property (unsafe_unretained, nonatomic) IBOutlet UIButton *selectFriendsButton;
@property (retain, nonatomic) FBFriendPickerViewController *friendPickerController;
@property (retain, nonatomic) UISearchBar *searchBar;
@property (retain, nonatomic) NSString *searchText;
@property (retain, nonatomic) NSMutableArray *baladeiros;
@property (weak, nonatomic) IBOutlet UITableView *tableView;
@property (weak, nonatomic) IBOutlet UITextField *valorTotal;


@end

@implementation RDBViewController
id<FBGraphUser> cachedUser;

-(void)loginViewFetchedUserInfo:(FBLoginView *)loginView user:(id<FBGraphUser>)user{
    if (![self isUser:cachedUser equalToUser:user]) {
        cachedUser = user;
        [_baladeiros addObject:user];
        [_tableView reloadData];
    }
}

- (BOOL)isUser:(id<FBGraphUser>)firstUser equalToUser:(id<FBGraphUser>)secondUser {
    if([firstUser.id isEqual:secondUser.id])
        return YES;
    else
        return NO;
}

// Handle possible errors that can occur during login
- (void)loginView:(FBLoginView *)loginView handleError:(NSError *)error {
    NSString *alertMessage, *alertTitle;
    
    // If the user should perform an action outside of you app to recover,
    // the SDK will provide a message for the user, you just need to surface it.
    // This conveniently handles cases like Facebook password change or unverified Facebook accounts.
    if ([FBErrorUtility shouldNotifyUserForError:error]) {
        alertTitle = @"Facebook error";
        alertMessage = [FBErrorUtility userMessageForError:error];
        
        // This code will handle session closures that happen outside of the app
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

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

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
    loginView.readPermissions = @[@"basic_info"];
    loginView.delegate = self;
    [self.view addSubview:loginView];
    [loginView sizeToFit];
}

- (void)viewDidUnload
{
    [self setSelectFriendsButton:nil];
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

- (IBAction)selectFriendsButtonAction:(id)sender {
    if (self.friendPickerController == nil) {
        // Create friend picker, and get data loaded into it.
        self.friendPickerController = [[FBFriendPickerViewController alloc] init];
        self.friendPickerController.title = @"Select Friends";
        self.friendPickerController.delegate = self;
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


- (UITableViewCell *) tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{

    static NSString *CellIdentifier = @"CellBaladeiro";
        
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier forIndexPath:indexPath];
    NSMutableArray<FBGraphUser> *fbuser = (NSMutableArray<FBGraphUser>*)[_baladeiros objectAtIndex:indexPath.row];
    
    UILabel *baladeiro = (UILabel*)[self.view viewWithTag:10];
    UILabel *valor = (UILabel*)[self.view viewWithTag:11];
    
    AsyncImageView *imageView = (AsyncImageView*)[self.view viewWithTag:12];
    imageView.clipsToBounds = YES;
    imageView.showActivityIndicator = YES;
    
    NSString *urlFoto = [NSString stringWithFormat:@"https://graph.facebook.com/%@/picture?type=normal&%@.png", fbuser.id, fbuser.id];
    
    [imageView setImageURL:[NSURL URLWithString:urlFoto]];

    imageView.layer.cornerRadius=imageView.frame.size.width/2;
    baladeiro.text = fbuser.name;
    if([_valorTotal.text isEqualToString:@""])
        valor.text = @"";
    else {
        float racha = [_valorTotal.text floatValue]/_baladeiros.count;
        valor.text = [NSString stringWithFormat:@"R$ %.2f",racha];
    }

    return cell;
    
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    [self performSegueWithIdentifier:@"SegueToDetail" sender:indexPath];
}


#pragma mark Text Field Delegate

-(BOOL)textFieldShouldReturn:(UITextField *)textField {
    [_valorTotal resignFirstResponder];
    return YES;
}

#pragma mark - Segues

-(void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    if([[segue identifier] isEqualToString:@"SegueToDetail"]) {
        RDBBaladeiro *baladeiro = [[RDBBaladeiro alloc]init];
        NSUInteger cellRow = [(NSIndexPath *)sender row];
        [baladeiro setFbuser:(NSMutableArray<FBGraphUser>*)[_baladeiros objectAtIndex:cellRow]];

        RDBGastoViewController *detailController = [segue destinationViewController];
        [detailController setBaladeiro:baladeiro];
        [detailController setBaladeiros:self.baladeiros];
    }
}


@end
