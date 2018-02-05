//Closure examples
func square(a: Float) -> Float {
	return a * a
}

func cube(a: Float) -> Float {
	return a * a * a
}

func averageOfFunction(a: Float, b: Float, f:(Float -> Float)) -> Float {
	return (f(a) + f(b)) / 2
}

averageOfFunction(2, 3, square)
averageOfFunction(2, 3, cube)
averageOfFunction(2, 3, {(x: Float) -> Float in return x * x})
averageOfFunction(2, 3, {x in return x * x})
averageOfFunction(2, 3, {$0 * $0})


//High order functions

//Map examples
var numbers = [10,20,45,32]
numbers.map({n in "\(n)€"})
numbers.map({ "\($0)€" })
numbers.map({ $0 + 1 })

//Filter example
numbers.filter({n in n > 30})
numbers.filter({ $0 > 30})

//Reduce example
numbers.reduce(1,{$0 + $1})
numbers.reduce(1,+)
