package com.example.calculadora_krolin

import junit.framework.TestCase.assertEquals
import org.junit.Test

class MainActivityTest {

    @Test
    fun suma() {
        val test = TestCalculadora()
        val resultado = test.suma(2, 3)
        assertEquals(5, resultado)
    }

    @Test
    fun resta() {
        val test = TestCalculadora()
        val resultado = test.resta(5, 3)
        assertEquals(2, resultado)
    }

    @Test
    fun multiplicar() {
        val test = TestCalculadora()
        val resultado = test.multiplicar(4, 6)
        assertEquals(24, resultado)
    }

    @Test
    fun dividir() {
        val test = TestCalculadora()
        val resultado = test.dividir(8, 2)
        assertEquals(4, resultado)
    }

    @Test
    fun potenciar() {
        val test = TestCalculadora()
        val resultado = test.potenciar(2, 3)
        assertEquals(8, resultado)
    }
}