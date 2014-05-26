//
//  ConverterTest.m
//  dojo
//
//  Created by Jéferson Machado on 25/05/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import <XCTest/XCTest.h>
#import "Converter.h"

@interface ConverterTest : XCTestCase

@end

@implementation ConverterTest

- (void)setUp
{
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown
{
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void)testExample
{
    Converter *c = [[Converter alloc] init];
    int result = [c convert:@"V"];
    XCTAssertEqual(result, 0, @"Result should be 0");
}

@end
