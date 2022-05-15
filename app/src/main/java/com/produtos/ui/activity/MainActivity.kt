package com.produtos.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.produtos.R
import com.produtos.dao.ProdutoDao
import com.produtos.databinding.ActivityMainBinding
import com.produtos.model.Produto
import com.produtos.ui.reciclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val produtoDao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(this, produtoDao.listAll())

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.updateList(produtoDao.listAll())
        configureFab()
    }

    private fun configureFab() {
        binding.btnAddProd.setOnClickListener {
            Intent(this, FormProdActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun configureRecyclerView() {
        binding.recyclerProdutos.adapter = adapter
    }

}