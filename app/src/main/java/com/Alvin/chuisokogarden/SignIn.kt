package com.Alvin.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignIn : AppCompatActivity() {
    //    https://alvin.alwaysdata.net/api/getproductdetails
//    https://alvin.alwaysdata.net/api/signup
//    https://alvin.alwaysdata.net/api/signin
//    https://alvin.alwaysdata.net/api/mpesa_payment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signInlink = findViewById<TextView>(R.id.signIn_link)
//        click listener
        signInlink.setOnClickListener {
            val signInlinkIntent = Intent(applicationContext, SignUp::class.java)
            startActivity(signInlinkIntent)

        }


//    finding the edittext buttons by id

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val signinbutton = findViewById<Button>(R.id.sign)
        signinbutton.setOnClickListener {
            val api = "https://kiruialvin.alwaysdata.net/api/signin"


//    request params in the container used to collect the user details its like form data in js

            val data = RequestParams()
            data.put("email", email.text.toString())
            data.put("password", password.text.toString().trim())


//    Api helper-it delivers our data to the api

            val helper = ApiHelper(applicationContext)
            helper.post_login(api, data)
        }
    }
}
