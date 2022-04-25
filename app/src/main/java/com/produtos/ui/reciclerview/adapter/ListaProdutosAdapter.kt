package com.produtos.ui.reciclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.produtos.R
import com.produtos.model.Produto

class ListaProdutosAdapter(
    private val context : Context,
    private val produtos: List<Produto>) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produto) {
            itemView.findViewById<TextView>(R.id.nome).text = produto.nome
            itemView.findViewById<TextView>(R.id.descricao).text = produto.descricao
            itemView.findViewById<TextView>(R.id.valor).text = produto.valor.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(
            R.layout.produto_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vincula(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size
}