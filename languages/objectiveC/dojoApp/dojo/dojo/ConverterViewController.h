//
//  ConverterViewController.h
//  dojo
//
//  Created by Jéferson Machado on 25/05/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ConverterViewController : UIViewController

{
    IBOutlet UITextField *romanNumber;
    IBOutlet UITextField *resultNumber;
    
}

-(IBAction)Convert:(id)sender;

@end
