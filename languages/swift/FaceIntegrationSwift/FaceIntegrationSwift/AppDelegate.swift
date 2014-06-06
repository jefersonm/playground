//
//  AppDelegate.swift
//  FaceIntegrationSwift
//
//  Created by Jéferson Machado on 05/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
                            
	var window: UIWindow?

	func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: NSDictionary?) -> Bool {
		
		return true
	}
	
	func application(application: UIApplication!, openURL url: NSURL!, sourceApplication: String!, annotation: AnyObject!) -> Bool  {

		return FBAppCall.handleOpenURL(url, sourceApplication: sourceApplication)
	}
	
}

