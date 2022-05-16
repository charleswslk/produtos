package com.produtos.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.produtos.databinding.FormProdImageBinding
import com.produtos.ui.ext.loadExt

class FormProdImgDialog(private val context: Context) {

    fun show(urlImg: String? = null, whenload: (img: String) -> Unit) {

        FormProdImageBinding.inflate(LayoutInflater.from(context)).apply {

            urlImg.let {
                edtFormProdImageUrl.setText(urlImg)
                imgFormProdImage.loadExt(urlImg)
            }

            btnFormProdImageCarregar.setOnClickListener {
                val url = edtFormProdImageUrl.text.toString()
                imgFormProdImage.loadExt(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = edtFormProdImageUrl.text.toString()
                    whenload(url)
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .show()

        }
    }
}