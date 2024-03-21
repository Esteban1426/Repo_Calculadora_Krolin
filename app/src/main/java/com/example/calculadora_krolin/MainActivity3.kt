package com.example.calculadora_krolin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var numeroUsuario: EditText
    private lateinit var botonCalcular: Button
    private lateinit var listaFibonacci: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        numeroUsuario = findViewById(R.id.numeroPosi)
        botonCalcular = findViewById(R.id.CF)
        listaFibonacci = findViewById(R.id.resultadof)

        botonCalcular.setOnClickListener {
            calcularMetodoFibonacci()
        }
    }

    private fun mostrarAlerta(titulo: String, mensaje: String) {
        val estructura = AlertDialog.Builder(this)
        estructura.setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", null)

        val alert = estructura.create()
        alert.show()
    }

    fun calcularMetodoFibonacci() {
        val input = numeroUsuario.text.toString()

        if (input.isEmpty()) {
            mostrarAlerta("Error", "Por favor, ingresa un número primero.")
        } else {
            val n = input.toInt()

            val sequenceBuilder = StringBuilder()
            for (i in 0..n) {
                val fib = fibonacci(i.toLong())
                sequenceBuilder.append(fib)
                if (i < n) {
                    sequenceBuilder.append(", ")
                }
            }

            listaFibonacci.text = "Lista de Fibonacci hasta la posición $n:\n${sequenceBuilder.toString()}"
        }
    }
    fun fibonacci(n: Long): Long {
        if (n == 0L) {
            return 0
        } else if (n == 1L) {
            return 1
        }

        var a = 0L
        var b = 1L
        var fib = 0L

        for (i in 2..n) {
            fib = a + b
            a = b
            b = fib
        }

        return fib
    }

    fun volver(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}