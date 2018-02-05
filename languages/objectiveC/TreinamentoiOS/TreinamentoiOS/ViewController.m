//
//  ViewController.m
//  TreinamentoiOS
//
//  Created by Jéferson Machado on 7/1/15.
//  Copyright (c) 2015 Jéferson Machado. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self.loginText setText:@"Welcome"];
    //self.loginText.text = @"Jeff";
}


- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event {
    [self.userTxt resignFirstResponder];
    [self.passTxt resignFirstResponder];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)loginBtn:(id)sender {
    NSLog(@"Button clicked");
    
    if([self.userTxt.text isEqualToString:@"jeff"] && [self.passTxt.text isEqualToString: @"123"]) {
        NSLog(@"login ok");
        [self navigateToAnotherClass];
    } else {
        NSLog(@"login falhou");
        
        NSString *errorMsg;
        if ([self.userTxt.text isEqualToString:@""] && [self.passTxt.text isEqualToString:@""]) {
            errorMsg = @"User and password are required.";
        } else {
            errorMsg = @"Wrong user and password";
        }
        
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"Error Message"
                                                        message:errorMsg
                                                       delegate:self
                                              cancelButtonTitle:@"OK"
                                              otherButtonTitles:nil];
        
        
        [alert show];
        
        //setar o cursor para o field de user
    }
    
}

- (void)navigateToAnotherClass {
    SecondViewController *secondView = [self.storyboard instantiateViewControllerWithIdentifier:@"secondView"];
    
//    secondView = [[SecondViewController alloc] init];

    secondView.userName = self.userTxt.text;
    
    [self presentViewController:secondView animated:YES completion:nil];
}

@end
