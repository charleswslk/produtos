package com.produtos.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.produtos.R
import com.produtos.model.Produto
import java.math.BigDecimal

class FormProdActivity : AppCompatActivity(R.layout.activity_form_prod) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edtNomeProd)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricaoProd)
        val edtValor = findViewById<EditText>(R.id.edtValorProd)

        val produto = Produto(
            edtNome.text.toString(),
            edtDescricao.text.toString(),
            BigDecimal("0.00")
           // BigDecimal(edtValor.text?.toString())
        )

        Log.d("FormProd", produto.toString())
    }
}