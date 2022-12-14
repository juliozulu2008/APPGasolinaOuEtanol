package com.juliocdias.gasolinaouetanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    var valorGasolina = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // carregando os componentes
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val txtGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btn = findViewById<Button>(R.id.btnCalcular)
        // Tamanho de Valores SeekBar
        seekbar.max = 1000
        // definindo um listener para s seekbar
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valorGasolina = p1
                var texto = "R$ "
                texto += formataValor(valorGasolina/100.0)
                txtGasolina.text = texto
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                txtResultado.text = "Selecione o Valor da Gasolina"
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                txtResultado.text = "Clique em Calcular para saber o Resultado"
            }

        })
        // Listener do Botao
        btn.setOnClickListener{
            var valorResultado = (valorGasolina * 0.7)/100.0
            var texto = "Abasteça com Etanol (Alcool) se ele custar até: R$  "
            texto += formataValor(valorResultado)
            txtResultado.text = texto
        }

    }

    private fun formataValor(valor: Double): Any? {
        return String.format(Locale.FRANCE, "%.2f", valor)  // O locaçe (local) esta como França pois eles tambem usao a Virgula como separador.
    }
}