//
//  AppDelegate.m
//  FaceIntegrationObjc
//
//  Created by Jéferson Machado on 05/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <FacebookSDK/FacebookSDK.h>
#import "AppDelegate.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
	return YES;
}


// In order to process the response you get from interacting with the Facebook login process,
// you need to override application:openURL:sourceApplication:annotation:
- (BOOL)application:(UIApplication *)application openURL:(NSURL *)url
	sourceApplication:(NSString *)sourceApplication annotation:(id)annotation {
	
	// Call FBAppCall's handleOpenURL:sourceApplication to handle Facebook app responses
	return [FBAppCall handleOpenURL:url sourceApplication:sourceApplication];
}

@end