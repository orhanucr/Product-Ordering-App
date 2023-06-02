package com.example.orhan_ucar_vize2.activity

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.orhan_ucar_vize2.*
import com.example.orhan_ucar_vize2.model.Product
import com.example.orhan_ucar_vize2.services.ApiClientSingleton
import com.example.orhan_ucar_vize2.services.DummyService
import com.example.orhan_ucar_vize2.services.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var listProducts: ListView

    lateinit var dummyService: DummyService
    lateinit var products: List<Product>

    var policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        listProducts = findViewById(R.id.productListView)

        StrictMode.setThreadPolicy(policy)
        dummyService = ApiClientSingleton.getInstance().create(DummyService::class.java)

        products = listOf()

        var productsAdapter = ProductsAdapter(this, products)
        listProducts.adapter = productsAdapter

        dummyService.getProducts().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    val productResponse = response.body()
                    if (productResponse != null) {
                        products = productResponse.products
                        val productsAdapter = ProductsAdapter(this@ProductList, products)
                        listProducts.adapter = productsAdapter
                    }
                } else {
                    Toast.makeText(this@ProductList, "Failed to fetch products", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("error:", t.toString())
                Toast.makeText(this@ProductList, "Failed to fetch products", Toast.LENGTH_LONG).show()
            }
        })
    }
}