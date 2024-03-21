package com.example.calculadora_krolin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var numero: TextView
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        numero = findViewById(R.id.Numero)
        resultado = findViewById(R.id.resultadoFac)
        val btnFactorial = findViewById<Button>(R.id.GotoFactorial)

        btnFactorial.setOnClickListener {
            calcularFactorial()
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

    private fun calcularFactorial() {
        val input = numero.text.toString()

        if (input.isEmpty()) {
            mostrarAlerta("Error", "Por favor, ingresa un número primero.")
        } else {
            val valor = input.toInt()
            val resultado = calcularFactorial(valor)

            if (resultado == -1L) {
                this.resultado.text = "No se puede calcular el factorial de un número negativo."
            } else {
                this.resultado.text = "El factorial de $valor es: $resultado"
            }
        }
    }

    private fun calcularFactorial(n: Int): Long {
        return if (n < 0) {
            -1
        } else if (n == 0 || n == 1) {
            1
        } else {
            n.toLong() * calcularFactorial(n - 1)
        }
    }

    fun volver(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}