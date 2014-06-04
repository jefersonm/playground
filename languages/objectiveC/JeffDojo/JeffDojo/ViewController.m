//
//  ViewController.m
//  JeffDojo
//
//  Created by Jéferson Machado on 30/01/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UILabel *nome;

-(IBAction)clickButtonAction:(id)sender;
@end

@implementation ViewController

- (void)viewDidLoad
{
    NSString *nome;
    nome=@"blabl abla";
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    _nome.text=nome;
    
    UILabel *label2 = [[UILabel alloc]initWithFrame:CGRectMake(100, 100, 100, 20)];
    label2.text=@"feitooooo!";
    [self.view addSubview:label2];
    

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(IBAction)clickButtonAction:(id)sender{
    NSLog(@"Clicou no maldito botão");
}

-(IBAction)clickButtonAction2:(id)sender{
    NSLog(@"Clicou no maldito botão2 agora vai");
}

@end
