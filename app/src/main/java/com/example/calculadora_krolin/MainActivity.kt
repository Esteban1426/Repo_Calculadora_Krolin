package com.example.calculadora_krolin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var mensaje: TextView
    lateinit var v1: EditText
    lateinit var v2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mensaje = findViewById(R.id.Resultado)
        v1 = findViewById(R.id.Caja1)
        v2 = findViewById(R.id.Caja2)

        val btnSuma = findViewById<Button>(R.id.Suma)
        val btnResta = findViewById<Button>(R.id.Resta)
        val btnMultiplicacion = findViewById<Button>(R.id.Multiplicacion)
        val btnDivision = findViewById<Button>(R.id.Division)
        val btnPotenciacion = findViewById<Button>(R.id.Potencia)

        btnSuma.setOnClickListener { Suma() }
        btnResta.setOnClickListener { Resta() }
        btnMultiplicacion.setOnClickListener { Multiplicar() }
        btnDivision.setOnClickListener { Dividir() }
        btnPotenciacion.setOnClickListener { Potenciar() }
    }

    fun Suma() {
        val valor1 = v1.text.toString().toInt()
        val valor2 = v2.text.toString().toInt()
        val resultado = valor1 + valor2
        mensaje.text = "El resultado es: $resultado"
    }

    fun Resta() {
        val valor1 = v1.text.toString().toInt()
        val valor2 = v2.text.toString().toInt()
        val resultado = valor1 - valor2
        mensaje.text = "El resultado es: $resultado"
    }

    fun Multiplicar() {
        val valor1 = v1.text.toString().toInt()
        val valor2 = v2.text.toString().toInt()
        val resultado = valor1 * valor2
        mensaje.text = "El resultado es: $resultado"
    }

    fun Dividir() {
        val valor1 = v1.text.toString().toInt()
        val valor2 = v2.text.toString().toInt()

        if (valor2 == 0) {
            mensaje.text = "No se puede dividir por cero"
        } else {
            val resultado = valor1 / valor2
            mensaje.text = "El resultado es: $resultado"
        }
    }

    fun Potenciar() {
        val base = v1.text.toString().toLong()
        val exponente = v2.text.toString().toLong()
        val resultado = calcularPotencia(base, exponente)
        mensaje.text = "El resultado es: $resultado"
    }

    private fun calcularPotencia(base: Long, exponente: Long): Long {
        return if (exponente == 0L) {
            1
        } else if (exponente < 0) {
            1 / calcularPotencia(base, -exponente)
        } else {
            base * calcularPotencia(base, exponente - 1)
        }
    }

    fun gotoFactorial(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun metodoF(view: View) {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
}