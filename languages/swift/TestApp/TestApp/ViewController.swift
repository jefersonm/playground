//
//  ViewController.swift
//  TestApp
//
//  Created by Jéferson Machado on 03/06/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
	
	@IBOutlet var btn_send: UIButton
	@IBOutlet var txt_input: UITextField
	@IBOutlet var lab_result: UILabel

	
	@IBAction func clicBtn(AnyObject) {
		lab_result.text = txt_input.text
	}
	
	override func viewDidLoad() {
		super.viewDidLoad()
	}

	override func didReceiveMemoryWarning() {
		super.didReceiveMemoryWarning()
	}


}

