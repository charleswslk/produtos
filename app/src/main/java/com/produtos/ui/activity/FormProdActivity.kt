package com.produtos.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.produtos.R
import com.produtos.dao.ProdutoDao
import com.produtos.model.Produto
import java.math.BigDecimal

class FormProdActivity : AppCompatActivity(R.layout.activity_form_prod) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val produtoDao = ProdutoDao()

        findViewById<Button>(R.id.btn_form_prod_save).setOnClickListener {
            produtoDao.add(createProduct())
            finish()
        }

        findViewById<Button>(R.id.btn_form_prod_cancel).setOnClickListener {
            finish()
        }
    }

    private fun createProduct(): Produto {
        val nome = findViewById<EditText>(R.id.edt_form_prod_nome).toString()
        val descricao = findViewById<EditText>(R.id.edt_form_prod_descricao).toString()
        val valor = "0.00"

        val produto = Produto(
            nome,
            descricao,
            BigDecimal(valor)
        )
        return produto
    }
}