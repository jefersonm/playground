#import <XCTest/XCTest.h>
#import "Converter.h"

@interface ConverterTest : XCTestCase

@end

@implementation ConverterTest

- (void)setUp {
    [super setUp];
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
    [super tearDown];
}

- (void)testNumberOne {
    Converter *c = [[Converter alloc] init];
    NSInteger result = [c convertBigNumbers:@"I"];
    XCTAssertEqual(result, 1, @"Result should be 1");
}

- (void)testNumberTwo {
	Converter *c = [Converter new];
	NSInteger result = [c convertBigNumbers:@"II"];
	XCTAssertEqual(result, 2, @"Result should be 2");
}

- (void)testNumberThree {
	Converter *c = [Converter new];
	NSInteger result = [c convertBigNumbers:@"III"];
	XCTAssertEqual(result, 3, @"Result should be 3");
}

- (void) testNumberFour {
	Converter *c = [Converter new];
	NSInteger result = [c convertBigNumbers:@"IV"];
	XCTAssertEqual(result, 4, @"Result should be 4");
}

- (void) testNumberSeven{
	Converter *c = [Converter new];
	NSInteger result = [c convertBigNumbers:@"VII"];
	XCTAssertEqual(result, 7, @"Result should be 7");
}

- (void) testNumberEighteen{
	Converter *c = [Converter new];
	NSInteger result = [c convertBigNumbers:@"XVIII"];
	XCTAssertEqual(result, 18, @"Result should be 18");
}


@end
