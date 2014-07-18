//
//  FacebookController.h
//  RachaDaGalera
//
//  Created by Jéferson Machado on 08/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface FacebookController : UIViewController <UITableViewDataSource, UITableViewDelegate, UITextFieldDelegate>

- (IBAction)selectFriendsButtonAction:(id)sender withController:(FBViewController*)controller;

@end
