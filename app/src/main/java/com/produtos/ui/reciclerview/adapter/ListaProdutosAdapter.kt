package com.produtos.ui.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.produtos.R
import com.produtos.databinding.ProdutoItemBinding
import com.produtos.model.Produto
import com.produtos.ui.ext.loadExt
import java.text.NumberFormat
import java.util.*

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtosM = produtos.toMutableList()

    class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nome = binding.nome
        private val descricao = binding.descricao
        private val valor = binding.valor
        private val imagem = binding.imgProdutoItem

        fun vincula(produto: Produto) {

            nome.text = produto.nome
            descricao.text = produto.descricao
            val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            valor.text = numberFormat.format(produto.valor)

            val visibility = if (produto.imagemUrl == null || produto.imagemUrl == "") View.GONE else View.VISIBLE

            imagem.visibility = visibility

            imagem.loadExt(produto.imagemUrl)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProdutoItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(produtosM[position])
    }

    override fun getItemCount(): Int = produtosM.size

    fun updateList(produtos: List<Produto>) {
        produtosM.clear()
        produtosM.addAll(produtos)
        notifyDataSetChanged()
    }
}