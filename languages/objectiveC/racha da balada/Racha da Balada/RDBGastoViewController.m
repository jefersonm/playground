//
//  RDBGastoViewController.m
//  Racha da Balada
//
//  Created by Rafael Sperling on 09/01/14.
//  Copyright (c) 2014 Rafael Sperling. All rights reserved.
//

#import "RDBGastoViewController.h"
#import <QuartzCore/QuartzCore.h>

@interface RDBGastoViewController ()

@end

NSMutableArray *tragos;

@implementation RDBGastoViewController


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
    tragos = [[NSMutableArray alloc]init];
    [tragos addObject:@"Combo de Vodka"];
    [tragos addObject:@"Cerveja"];
    [tragos addObject:@"Sou fraco, comprei agua"];
    [tragos addObject:@"Sou bixa, comprei suco"];
    [self setPhoto];
}

-(void)setPhoto{
    NSString *urlFoto = [NSString stringWithFormat:@"https://graph.facebook.com/%@/picture?type=normal&%@.png", _baladeiro.fbuser.id, _baladeiro.fbuser.id];
     [_baladeiroImageView setImageURL:[NSURL URLWithString:urlFoto]];
    _baladeiroImageView.layer.cornerRadius=_baladeiroImageView.frame.size.width/2;

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - UITableView Delegate Methods

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    if(tableView == self.tragoTableView)
        return tragos.count;
    if(tableView == self.baladeirosTableView)
        return self.baladeiros.count;
    
    return 0;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    UITableViewCell *cell;
    
    if(tableView == self.tragoTableView){
        cell = [tableView dequeueReusableCellWithIdentifier:@"TragoCell" forIndexPath:indexPath];
        cell.textLabel.text=[NSString stringWithFormat:@"%@",[tragos objectAtIndex:indexPath.row]];
    }
    
    if(tableView == self.baladeirosTableView){
        cell = [tableView dequeueReusableCellWithIdentifier:@"BaladeiroCell" forIndexPath:indexPath];
        NSMutableArray<FBGraphUser> *fbuser = (NSMutableArray<FBGraphUser>*)[_baladeiros objectAtIndex:indexPath.row];
        
        UILabel *baladeiro = (UILabel*)[self.view viewWithTag:10];
        
        AsyncImageView *imageView = (AsyncImageView*)[self.view viewWithTag:12];
        imageView.clipsToBounds = YES;
        imageView.showActivityIndicator = YES;
        
        NSString *urlFoto = [NSString stringWithFormat:@"https://graph.facebook.com/%@/picture?type=normal&%@.png", fbuser.id, fbuser.id];
        
        [imageView setImageURL:[NSURL URLWithString:urlFoto]];
        imageView.layer.cornerRadius=imageView.frame.size.width/2;

        baladeiro.text = fbuser.name;

    }
    
    return cell;
}

#pragma mark - Segue

-(void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    //    if([[segue identifier] isEqualToString:@"backtoRacha"])
    //    {
    //        RDBGastoViewController *smvc = (RDBGastoViewController *)segue.destinationViewController;
    //    }
    
}

@end
