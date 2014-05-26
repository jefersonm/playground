//
//  Card.m
//  iosDojo
//
//  Created by Jéferson Machado on 25/05/14.
//  Copyright (c) 2014 Jéferson Machado. All rights reserved.
//

#import "Card.h"

@interface Card()

@end

@implementation Card

- (int)match:(NSArray *)otherCards
{
    int score = 0;
    for (Card *card in otherCards)
    {
        if ([card.contents isEqualToString:self.contents])
        {
            score = 1;
        }
    }
    return score;
}

@end