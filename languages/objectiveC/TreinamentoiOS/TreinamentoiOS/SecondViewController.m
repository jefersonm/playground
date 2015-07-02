//
//  SecondViewController.m
//  TreinamentoiOS
//
//  Created by Jéferson Machado on 7/1/15.
//  Copyright (c) 2015 Jéferson Machado. All rights reserved.
//

#import "SecondViewController.h"

@interface SecondViewController ()

@end

@implementation SecondViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
//  [self.userNameLabel setText:@"Welcome"];
//    self.userNameLabel.text = self.userName;
    self.userNameLabel.text = [NSString stringWithFormat:@"%@ %@", @"Welcome", self.userName];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)logoutBtn:(id)sender {
    NSLog(@"Log out");
    
    [self navigateToFirstView];
}

- (void)navigateToFirstView {
    ViewController *firstView = [self.storyboard instantiateViewControllerWithIdentifier:@"firstView"];
    
    [self presentViewController:firstView animated:YES completion:nil];
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
