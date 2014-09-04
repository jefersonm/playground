#import <Foundation/Foundation.h>

@interface Converter : NSObject

@property (nonatomic, strong) NSString *romanNumber;

- (NSInteger)convertSingle:(NSString *)romanNumber;
- (NSArray *)splitRomanNumber:(NSString *)romanNumber;
- (NSInteger)converter:(NSString *)romanNumber;
- (NSInteger)convertBigNumbers:(NSString *)romanNumber;

@end
