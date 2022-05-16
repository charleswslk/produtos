package com.produtos.dao

import com.produtos.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    fun add(produto: Produto) {
        listProduto.add(produto)
    }

    fun listAll(): List<Produto> {
        return listProduto.toList()
    }

    companion object {
        private val listProduto = mutableListOf<Produto>(
            Produto(
                nome = "Banana",
                descricao = "Banana madura",
                valor = BigDecimal("5.00"),
                imagemUrl = "https://images.pexels.com/photos/2872755/pexels-photo-2872755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            ),
            Produto(
                nome = "Maçã",
                descricao = "Maçã Verde",
                valor = BigDecimal("15.00")
            )

        )
    }

}