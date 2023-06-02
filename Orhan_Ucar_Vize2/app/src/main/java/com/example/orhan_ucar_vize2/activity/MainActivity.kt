package com.example.orhan_ucar_vize2.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import com.example.orhan_ucar_vize2.R

class MainActivity : AppCompatActivity() {

    private lateinit var nameText: EditText
    private lateinit var passwordText: EditText
    private lateinit var btnGiris: TextView
    private lateinit var btnKayit: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        nameText = findViewById(R.id.nameText)
        passwordText = findViewById(R.id.passwordText)
        btnGiris = findViewById(R.id.btnGiris)
        btnKayit = findViewById(R.id.btnKayit)

        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Kayıt butonuna tıklanınca
        btnKayit.setOnClickListener {
            val name = nameText.text.toString()
            val password = passwordText.text.toString()

            // Kullanıcı adı ve şifre kontrolü
            if (name.isNotEmpty() && password.isNotEmpty()) {
                // Kullanıcıyı kaydet
                val success = saveUser(name, password)
                if (success) {
                    Toast.makeText(this, "Kayıt başarılı", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Kayıt başarısız", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Kullanıcı adı ve şifre gereklidir", Toast.LENGTH_SHORT).show()
            }
        }

        // Giriş butonuna tıklanınca
        btnGiris.setOnClickListener {
            val name = nameText.text.toString()
            val password = passwordText.text.toString()

            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Kullanıcı adı ve şifre gereklidir", Toast.LENGTH_SHORT).show()
            } else {
                // Kayıtlı kullanıcı bilgilerini kontrol et
                val savedName = sharedPreferences.getString("name", "")
                val savedPassword = sharedPreferences.getString("password", "")

                if (name == savedName && password == savedPassword) {
                    Toast.makeText(this, "Giriş başarılı", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ProductList::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Kullanıcı adı veya şifre hatalı", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun saveUser(name: String, password: String): Boolean {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("password", password)
        return editor.commit()
    }
}