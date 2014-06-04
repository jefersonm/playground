//
//  RDBGastoViewController.h
//  Racha da Balada
//
//  Created by Rafael Sperling on 09/01/14.
//  Copyright (c) 2014 Rafael Sperling. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RDBBaladeiro.h"
#import "AsyncImageView.h"

@interface RDBGastoViewController : UIViewController <UITableViewDataSource, UITableViewDelegate>

@property (retain, nonatomic) RDBBaladeiro *baladeiro;
@property (retain, nonatomic) NSMutableArray *baladeiros;
@property (weak, nonatomic) IBOutlet AsyncImageView *baladeiroImageView;
@property (weak, nonatomic) IBOutlet UITableView *tragoTableView;
@property (weak, nonatomic) IBOutlet UITableView *baladeirosTableView;

@end
