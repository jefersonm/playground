package com.jefersonm.playground.kotlin

fun main(args: Array<String>) {
    println("max: ${max(2, 3)}")

    loops("Hello")
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun loops(obj: Any) {
    //While loop
    var index = 0
    while(index < 10)
        println(index++)

    //For loop
    val fruits = listOf("apple", "banana", "avocado")
    for(fruit in fruits) {
        println(fruit)
    }

    //Range and in
    val number = 7
    if (number in 1..10)
        println("Number found")

    var names = arrayListOf<String>()
    names.add("jeff")
    names.add("bah")

    if("jeff" in names)
        println("Name found")

    //When
    when(obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}