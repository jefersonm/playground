import Test.HUnit

fizzbuzz n = [condition x | x <- [1 .. n]]

condition x
	| rem x 3 == 0 && rem x 5 == 0  = "fizzbuzz"
	| rem x 3 == 0 					= "fizz"
	| rem x 5 == 0 					= "buzz"
	| otherwise  					= show x

testFizz 		= TestCase (assertEqual "Should return until Fizz]" 	["1", "2", "fizz"] (fizzbuzz 3))
testBuzz 		= TestCase (assertEqual "Should return until Buzz" 		["1", "2", "fizz", "4", "buzz"] (fizzbuzz 5))
testFizzBuzz 	= TestCase (assertEqual "Should return until FizzBuzz" 	["1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"] (fizzbuzz 15))

myTests = TestList [testFizz, testBuzz, testFizzBuzz]