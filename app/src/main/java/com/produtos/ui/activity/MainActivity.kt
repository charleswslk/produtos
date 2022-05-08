package com.produtos.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.produtos.R
import com.produtos.model.Produto
import com.produtos.ui.reciclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recycleProduto = findViewById<RecyclerView>(R.id.recyclerProdutos)

        recycleProduto.adapter = ListaProdutosAdapter(this, listOf(
            Produto(nome = "Pessego", descricao = "Maduro", valor = BigDecimal("1.99")),
            Produto(nome = "Laranja", descricao = "Bem madura", valor = BigDecimal("5.34")),
            Produto("Maçã", "Maça Verde", BigDecimal("5.43"))
        ))

    }

}