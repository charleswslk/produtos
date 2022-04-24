package com.produtos.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.produtos.R
import com.produtos.model.Produto
import com.produtos.ui.reciclerview.adapter.listaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleProduto = findViewById<RecyclerView>(R.id.recyclerProdutos)

        val list = listOf(
            Produto(nome = "Pessego", descricao = "Maduro", valor = BigDecimal("1.99")),
            Produto(nome = "Laranja", descricao = "Bem madura", valor = BigDecimal("5.34")),
            Produto("Maçã", "Maça Verde", BigDecimal("5.43"))
        )

        recycleProduto.adapter = listaProdutosAdapter(this, list)

    }

}