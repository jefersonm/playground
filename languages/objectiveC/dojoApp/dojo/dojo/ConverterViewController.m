//
//  ConverterViewController.m
//  dojo
//
//  Created by Jéferson Machado on 25/05/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import "ConverterViewController.h"
#import "Converter.h"

@interface ConverterViewController ()

//@property (unsafe_unretained, nonatomic) IBOutlet UIButton *convertButton;
//@property (retain, nonatomic) NSString *romanText;

@end

@implementation ConverterViewController

-(IBAction)Convert:(id)sender{
    Converter *co = [[Converter alloc] init];
    int result = [co convert:romanNumber.text];
    resultNumber.text = [NSString stringWithFormat:@"%i", result];
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
