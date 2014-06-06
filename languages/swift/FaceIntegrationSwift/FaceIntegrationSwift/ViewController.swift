//
//  ViewController.swift
//  FaceIntegrationSwift
//
//  Created by Jéferson Machado on 05/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

import UIKit

class ViewController: UIViewController, FBLoginViewDelegate {
	
	@IBOutlet var profilePictureView: FBProfilePictureView
	@IBOutlet var nameLabel: UILabel
	@IBOutlet var statusLabel: UILabel
	
	override func viewDidLoad() {
		super.viewDidLoad()
		FBProfilePictureView()

		var loginView = FBLoginView()
		loginView.frame = CGRectOffset(loginView.frame, 50, 450);
		loginView.readPermissions = ["public_profile", "email", "user_friends"]
		loginView.delegate = self
		self.view.addSubview(loginView)
		loginView.sizeToFit()
	}

	func loginViewFetchedUserInfo(loginView: FBLoginView, user: AnyObject) {
		self.profilePictureView.profileID = user.id
		self.nameLabel.text = user.name
	}
	
	func loginViewShowingLoggedInUser(loginView: FBLoginView) {
		self.statusLabel.text = "You're logged in as"
	}
	
	func loginViewShowingLoggedOutUser(loginView: FBLoginView) {
		self.profilePictureView.profileID = nil
		self.nameLabel.text = ""
		self.statusLabel.text = "You're not logged in!"
	}

	func loginView(loginView: FBLoginView, error: NSError) {
		var errorHandling = LoginErrorHandling()
		errorHandling.loginView(loginView, handleError: error)
	}
	

}

