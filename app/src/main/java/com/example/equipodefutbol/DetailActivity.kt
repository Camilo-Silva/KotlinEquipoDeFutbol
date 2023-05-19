package com.example.equipodefutbol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var textViewApodo: TextView
    private  lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewApodo = findViewById(R.id.textViewApodo)
        imageView = findViewById(R.id.imageViewLogo)

        val bundle = intent.extras
        val nombre = bundle?.getString("apodo","")
        val url = bundle?.getString("url") ?: ""

        textViewApodo.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}