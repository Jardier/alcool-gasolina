package com.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var textPrecoAlcool    : TextInputEditText
    lateinit var textPrecoGasolina  : TextInputEditText
    lateinit var textResultado      : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textPrecoAlcool    = findViewById(R.id.tiePrecoAlcool)
        this.textPrecoGasolina  = findViewById(R.id.tiePrecoGasolina)
        this.textResultado      = findViewById(R.id.tvResultado)

        this.textResultado.text = "Preencha os preços"
    }

    fun calcular(view : View) {
        val precoAlcool : String = this.textPrecoAlcool.getText().toString();
        val precoGasolina : String = this.textPrecoGasolina.getText().toString();

        if(isCamposValidos(precoAlcool, precoGasolina)){
            val valorAlcool = precoAlcool.toDouble();
            val valorGasolina = precoGasolina.toDouble();

            if(valorGasolina.equals(0.0)){
                this.textResultado.text = "O valor da gasolina deve ser maior que zero!";
            }else {
                calcularMelhorPreco(valorAlcool,valorGasolina);
            }


        } else {
            this.textResultado.text = "Você deve informar os preços";
        }
    }

    private fun isCamposValidos(precoAlcool: String, precoGasolina : String) : Boolean {

        if(precoAlcool == null || "".equals(precoAlcool)){
            return false;
        } else if(precoGasolina == null || "".equals(precoGasolina)){
            return false;
        }
        return true;
    }
    private fun calcularMelhorPreco(valorAlcool : Double, valorGasolina: Double) {
        val resultado = valorAlcool / valorGasolina >= 0.7
        if(resultado) {
            this.textResultado.text = "É melhor utilizar Gasolina";
        } else {
            this.textResultado.text = "É melhor utilizar Álcool";
        }
    }
}
