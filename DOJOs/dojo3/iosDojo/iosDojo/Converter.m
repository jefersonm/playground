#import "Converter.h"

@implementation Converter

- (NSInteger)convertSingle:(NSString *)romanNumber {
    
	NSArray* splittedNumber = [self splitRomanNumber: romanNumber];
	
	if([romanNumber length] == 1) {
		return [self converter:romanNumber];
	}
	
	NSInteger num1 = [self converter:[splittedNumber objectAtIndex:0]];
	NSInteger num2 = [self converter:[splittedNumber objectAtIndex:1]];
	
	if(num1 < num2) {
		return num2 - num1;
	} else {
		return num1 + num2;
	}
	
}

- (NSInteger)convertBigNumbers:(NSString *)romanNumber {
	
	NSArray *splittedNumber = [self splitRomanNumber:romanNumber];
	
	NSInteger last = 0;
	NSInteger current = 0;
	NSInteger result =0;
	
	if ([splittedNumber count] == 1){
		return [self converter: [splittedNumber firstObject]];
	}
	
	for(NSString *number in splittedNumber) {
		
		if(last == 0) {
			last = [self converter:number];
			result += last;
			continue;
		}
		
		current = [self converter:number];
		
		if(last >= current){
			result += current;
		} else {
			result = current - result;
		}
		
		last = current;
		
	}
	
	return result;
	
}

- (NSInteger)converter:(NSString *)romanNumber {
	
	if ([romanNumber isEqualToString:@"I"]){
		return 1;
	} else if([romanNumber isEqualToString:@"V"]) {
		return 5;
	} else if([romanNumber isEqualToString:@"X"]) {
		return 10;
	}
	
    return 0;
}

- (NSArray *)splitRomanNumber:(NSString *)romanNumber {
	NSMutableArray *characters = [[NSMutableArray alloc] initWithCapacity:[romanNumber length]];
	for (int i = 0; i < [romanNumber length]; i++) {
		NSString *ichar  = [NSString stringWithFormat:@"%c", [romanNumber characterAtIndex:i]];
		[characters addObject:ichar];
	}
	return characters;
}

- (NSArray *)splitRomanNumberReverse:(NSString *)romanNumber {
	NSMutableArray *characters = [[NSMutableArray alloc] initWithCapacity:[romanNumber length]];
	for (int i = [romanNumber length] - 1; i >= 0; i++) {
		NSString *ichar  = [NSString stringWithFormat:@"%c", [romanNumber characterAtIndex:i]];
		[characters addObject:ichar];
	}
	return characters;
}


@end