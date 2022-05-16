package com.produtos.ui.ext

import android.widget.ImageView
import coil.load
import com.produtos.R

fun ImageView.loadExt(url : String?){

    load(url){
        fallback(R.drawable.no_imagem)
        error(R.drawable.no_imagem)
        placeholder(R.drawable.placeholder)
    }

}