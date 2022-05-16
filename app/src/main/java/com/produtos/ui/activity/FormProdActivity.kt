package com.produtos.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.produtos.R
import com.produtos.dao.ProdutoDao
import com.produtos.databinding.ActivityFormProdBinding
import com.produtos.databinding.FormProdImageBinding
import com.produtos.model.Produto
import com.produtos.ui.dialog.FormProdImgDialog
import com.produtos.ui.ext.loadExt
import java.math.BigDecimal

class FormProdActivity : AppCompatActivity() {
    private var url = ""

    private val binding by lazy {
        ActivityFormProdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastro de Produto"

        val produtoDao = ProdutoDao()
        binding.btnFormProdSave.setOnClickListener {
            produtoDao.add(createProduct())
            finish()
        }
        binding.btnFormProdCancel.setOnClickListener {
            finish()
        }
        binding.imgActivityFormProd.setOnClickListener {
            FormProdImgDialog(this).show(url){
                url = it
                binding.imgActivityFormProd.loadExt(url)
            }
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
            BigDecimal(valor),
            url
        )
        return produto
    }
}