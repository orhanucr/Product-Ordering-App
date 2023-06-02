package com.example.orhan_ucar_vize2

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.orhan_ucar_vize2.activity.Detail
import com.example.orhan_ucar_vize2.model.Product

class ProductsAdapter(private val context: Activity, private val list: List<Product>) :
    ArrayAdapter<Product>(context, R.layout.list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = context.layoutInflater.inflate(R.layout.list_item, null, true)

        val title = view.findViewById<TextView>(R.id.titleTextView)
        val thumbnail = view.findViewById<ImageView>(R.id.productImageView)
        val price = view.findViewById<TextView>(R.id.priceTextView)

        val product = list[position]

        title.text = product.title
        price.text = product.price.toString() + " TL"
        Glide.with(context).load(product.thumbnail).into(thumbnail)

        view.setOnClickListener {
            val intent = Intent(context, Detail::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }

        return view
    }
}
