//
//  LoginErrorHandling.h
//  RachaDaGalera
//
//  Created by Jéferson Machado on 07/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <FacebookSDK/FacebookSDK.h>

@interface LoginErrorHandling : NSObject

- (void)loginView:(FBLoginView *)loginView handleError:(NSError *)error;

@end
