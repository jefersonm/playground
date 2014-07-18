//
//  FacebookController.swift
//  RachaDaGalera
//
//  Created by Jéferson Machado on 07/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

import UIKit
import Foundation

class FBController: UIViewController, FBLoginViewDelegate, FBFriendPickerDelegate, UISearchBarDelegate, FBViewController {
	
	@IBOutlet var selectFriendsButton: UIButton
	@IBOutlet var friendPickerController: FBFriendPickerViewController
	
	@IBAction func selectFriendsButtonAction(id: AnyObject) {
		var facebookController = FacebookController()
		facebookController.selectFriendsButtonAction(id, withController: self)
	}
	
}