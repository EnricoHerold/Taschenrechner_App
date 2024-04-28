package com.example.spielwiese

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zahl1EditText = findViewById<EditText>(R.id.ErsteZahlEingegeben)
        val zahl2EditText = findViewById<EditText>(R.id.ZweiteZahlEingegeben)
        val ergebnisTextView = findViewById<TextView>(R.id.Ergebnis)

        val addierenButton = findViewById<Button>(R.id.Addieren)
        val subtrahierenButton = findViewById<Button>(R.id.Subtrahieren)
        val multiplizierenButton = findViewById<Button>(R.id.Multiplizieren)
        val dividierenButton = findViewById<Button>(R.id.Dividieren)

        addierenButton.setOnClickListener {
            val zahl1 = zahl1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val zahl2 = zahl2EditText.text.toString().toDoubleOrNull() ?: 0.0
            addieren(zahl1, zahl2, ergebnisTextView)
        }

        subtrahierenButton.setOnClickListener {
            val zahl1 = zahl1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val zahl2 = zahl2EditText.text.toString().toDoubleOrNull() ?: 0.0
            subtrahieren(zahl1, zahl2, ergebnisTextView)
        }

        multiplizierenButton.setOnClickListener {
            val zahl1 = zahl1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val zahl2 = zahl2EditText.text.toString().toDoubleOrNull() ?: 0.0
            multiplizieren(zahl1, zahl2, ergebnisTextView)
        }

        dividierenButton.setOnClickListener {
            val zahl1 = zahl1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val zahl2 = zahl2EditText.text.toString().toDoubleOrNull() ?: 0.0
            dividieren(zahl1, zahl2, ergebnisTextView)


        }
    }

    fun addieren(summand1: Double, summand2: Double, ergebnisTextView: TextView){
        val myTextView = findViewById<TextView>(R.id.Ergebnis)

        var summe: Double = summand1+summand2
        formatErgebnis(summe)
        myTextView.text = summe.toString()

    }

    fun subtrahieren(subtrahent1: Double, subtrahent2: Double, ergebnisTextView: TextView){
        val myTextView = findViewById<TextView>(R.id.Ergebnis)

        var ergebnis: Double = subtrahent1 - subtrahent2
        formatErgebnis(ergebnis)
        myTextView.text = ergebnis.toString()
    }

    fun multiplizieren(faktor1: Double, faktor2: Double, ergebnisTextView: TextView){
        val myTextView = findViewById<TextView>(R.id.Ergebnis)

        var produkt: Double = faktor1 * faktor2
        formatErgebnis(produkt)
        myTextView.text = produkt.toString()
    }

    fun dividieren(dividend: Double, divisor: Double, ergebnisTextView: TextView) {
        val myTextView = findViewById<TextView>(R.id.Ergebnis)

        if (divisor != 0.0) {
            val quotient: Double = dividend / divisor
            formatErgebnis(quotient)
            myTextView.text = quotient.toString()
        } else {
            myTextView.text = "Nicht erlaubt!"
        }
    }


    fun formatErgebnis(ergebnis: Double): String {
        if (ergebnis % 1.0 == 0.0) {
            // Ergebnis ist eine ganze Zahl
            return String.format("%.0f", ergebnis)
        } else {
            // Ergebnis hat relevante Nachkommastellen
            return ergebnis.toString()
        }

        val bd = BigDecimal(ergebnis).setScale(2, RoundingMode.HALF_UP)
        return bd.toString()
    }


}