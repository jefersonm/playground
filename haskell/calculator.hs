import Test.HUnit

calc operator a b = (operator a b)

testSum 	= TestCase (assertEqual "Sum" 				5 (calc (+) 2 3))
testSub 	= TestCase (assertEqual "Substraction" 		3 (calc (-) 5 2))
testDiv 	= TestCase (assertEqual "Division" 			3 (calc (/) 6 2))
testMult 	= TestCase (assertEqual "Multiplication" 	6 (calc (*) 3 2))

myTests = TestList [testSum, testSub, testDiv, testMult]