//
//  Converter.h
//  dojo
//
//  Created by Jéferson Machado on 25/05/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Converter : NSObject

@property (retain, nonatomic) NSString *romanNumber;

-(int)convert:(NSString*)romanNumber;

@end
