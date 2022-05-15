package com.produtos.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.produtos.R
import com.produtos.dao.ProdutoDao
import com.produtos.databinding.ActivityFormProdBinding
import com.produtos.model.Produto
import java.math.BigDecimal

class FormProdActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormProdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val produtoDao = ProdutoDao()

        binding.btnFormProdSave.setOnClickListener {
            produtoDao.add(createProduct())
            finish()
        }

        binding.btnFormProdCancel.setOnClickListener {
            finish()
        }

        binding.imgActivityFormProd.setOnClickListener {
            AlertDialog.Builder(this)
                .setView(R.layout.form_prod_image)
                .setPositiveButton("Confirmar") { _, _ ->

                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()

        }
    }

    private fun createProduct(): Produto {
        val nome = binding.edtFormProdNome.text.toString()
        val descricao = binding.edtFormProdDescricao.text.toString()
        var valor = binding.edtFormProdValor.text.toString()
        if (valor.equals(""))
            valor = "0.00"
        val produto = Produto(
            nome,
            descricao,
            BigDecimal(valor)
        )
        return produto
    }
}