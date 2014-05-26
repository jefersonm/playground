//
//  RDBBaladeiro.h
//  Racha da Balada
//
//  Created by Rafael Sperling on 1/22/14.
//  Copyright (c) 2014 Rafael Sperling. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <FacebookSDK/FacebookSDK.h>

@interface RDBBaladeiro : NSObject

@property (retain,nonatomic) NSMutableArray<FBGraphUser> *fbuser;
@property (retain,nonatomic) NSMutableArray *gastos;

@end
