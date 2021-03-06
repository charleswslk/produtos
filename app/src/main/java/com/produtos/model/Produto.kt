package com.produtos.model

import java.math.BigDecimal

class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagemUrl: String? = ""
) 