//
//  SecondViewController.h
//  TreinamentoiOS
//
//  Created by Jéferson Machado on 7/1/15.
//  Copyright (c) 2015 Jéferson Machado. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ViewController.h"

@interface SecondViewController : UIViewController

@property (weak, nonatomic) IBOutlet UILabel *welcomeText;

@property (weak, nonatomic) IBOutlet UIImageView *welcomeImage;

@property (readwrite) NSString *userName;

@property (weak, nonatomic) IBOutlet UILabel *userNameLabel;

@end
