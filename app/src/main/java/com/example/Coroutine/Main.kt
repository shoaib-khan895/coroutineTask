package com.example.Coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Run main() to see the output
 */
fun main() {
    GlobalScope.launch {
        printFibonacciSeries(20)
    }
    println("Fibonacci series of 10 is:")
    Thread.sleep(10000)
}

suspend fun printFibonacciSeries(endRange: Int) {
        var t1 = 0; var t2 = 1
    var nextTerm: Int
    for (i in 1..endRange) {
            print(" $t1")
            nextTerm = t1 + t2
        t1 = t2
        t2 = nextTerm
        delay(300)
        }
}