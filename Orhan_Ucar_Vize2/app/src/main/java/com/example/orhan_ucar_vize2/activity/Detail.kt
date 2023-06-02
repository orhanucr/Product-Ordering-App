package com.example.orhan_ucar_vize2.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.orhan_ucar_vize2.R
import com.example.orhan_ucar_vize2.model.Product

class Detail : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var detailTextView: TextView
    private lateinit var priceTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var productImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.titleTextView)
        detailTextView = findViewById(R.id.detailTextView)
        priceTextView = findViewById(R.id.priceTextView)
        ratingTextView = findViewById(R.id.ratingTextView)
        productImageView = findViewById(R.id.productImageView)

        val product = intent.getParcelableExtra<Product>("product")

        product?.let {
            titleTextView.text = it.title
            priceTextView.text = "Fiyat: ${it.price} TL"
            ratingTextView.text = "Oylama: ${it.rating}"

            Glide.with(this)
                .load(it.thumbnail)
                .into(productImageView)
        }
    }
}
