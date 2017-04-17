package main

import "fmt"

func sum(valOne, valTwo int) int {
	return valOne + valTwo
}

func swap(x, y string) (string, string) {
	return y, x
}

//naked return
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return
}

func defaultValues() {
	var i int
	var f float64
	var b bool
	var s string
	fmt.Printf("%v %v %v %q\n", i, f, b, s)
}

func conversion() {
	var i int = 42
	var f float64 = float64(i)
	var u uint = uint(f)
	fmt.Println(i, f, u)
}

//initializing variables, no type needed
var c, python = true, "no!"
const Pi = 3.14

func main() {
	fmt.Printf("sum: %d \n", sum(1, 4))	

	nameOne, nameTwo := swap("Jeff", "Mateus")
	fmt.Printf("names: %s, %s \n", nameOne, nameTwo)

	x, y := split(17)
	fmt.Printf("split values: %d, %d \n", x, y)

	var i int
	//short variable declaration
	k := 3
	fmt.Println(i, c, python, k)

	defaultValues()

	conversion()

	fmt.Println("Happy", Pi, "Day")
}
