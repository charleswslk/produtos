package com.produtos.dao

import com.produtos.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    fun add (produto : Produto){
      listProduto.add(produto)
    }

    fun listAll() : List<Produto>{
        return listProduto.toList()
    }

    companion object {
        private val listProduto = mutableListOf<Produto>(
            Produto(nome = "Banana",
                    descricao = "Banana madura",
                    valor = BigDecimal("5.00")
            )
        )
    }

}