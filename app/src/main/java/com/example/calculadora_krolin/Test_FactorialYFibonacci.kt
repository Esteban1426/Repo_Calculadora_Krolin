package com.example.calculadora_krolin

class TestFactorialYFibonacci {

    fun calcularFactorial(n: Int): Long {
        return if (n < 0) {
            -1
        } else if (n == 0 || n == 1) {
            1
        } else {
            n.toLong() * calcularFactorial(n - 1)
        }
    }

    fun calcularMetodoFibonacci(n: Int): Any {
        val sequenceBuilder = StringBuilder()
        for (i in 0..n) {
            val fib = fibonacci(i)
            sequenceBuilder.append(fib)
            if (i < n) {
                sequenceBuilder.append(", ")
            }
        }
        return n
    }

    fun fibonacci(n: Int): Int {
        if (n == 0) {
            return 0
        } else if (n == 1) {
            return 1
        }

        var a = 0
        var b = 1
        var fib = 0

        for (i in 2..n) {
            fib = a + b
            a = b
            b = fib
        }

        return fib
    }
}