package com.produtos.dao

import com.produtos.model.Produto

class ProdutoDao {

    fun add (produto : Produto){
      listProduto.add(produto)
    }

    fun listAll() : List<Produto>{
        return listProduto.toList()
    }

    companion object {
        private val listProduto = mutableListOf<Produto>()
    }

}