package com.example.calculadora_krolin

class TestCalculadora {

    fun suma(valor1: Int, valor2: Int): Int {
        return valor1 + valor2
    }

    fun resta(valor1: Int, valor2: Int): Int {
        return valor1 - valor2
    }

    fun multiplicar(valor1: Int, valor2: Int): Int {
        return valor1 * valor2
    }

    fun dividir(valor1: Int, valor2: Int): Int {
        if (valor2 == 0) {
            throw IllegalArgumentException("No se puede dividir por cero")
        }
        return valor1 / valor2
    }

    fun potenciar(base: Long, exponente: Long): Long {
        if (exponente < 0) {
            throw IllegalArgumentException("El exponente debe ser positivo o cero")
        }

        var resultado: Long = 1
        for (i in 0 until exponente) {
            resultado *= base
        }
        return resultado
    }
}