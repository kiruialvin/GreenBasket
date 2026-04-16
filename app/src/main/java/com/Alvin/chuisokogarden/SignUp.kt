package com.Alvin.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signInlink = findViewById<TextView>(R.id.signIn_link)
//        click listener
        signInlink.setOnClickListener {
            val signInlinkIntent = Intent(applicationContext, SignIn::class.java)
            startActivity(signInlinkIntent)

        }

        //    finding the edittext buttons by id
        val username=findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val phone=findViewById<EditText>(R.id.phone)
        val password = findViewById<EditText>(R.id.password)
        val signupbutton = findViewById<Button>(R.id.signup)
        signupbutton.setOnClickListener {
            val api = "https://kiruialvin.alwaysdata.net/api/signup"


//    request params in the container used to collect the user details its like form data in js

            val data = RequestParams()
            data.put("username",username.text.toString())
            data.put("email", email.text.toString())
            data.put("phone",phone.text.toString())
            data.put("password", password.text.toString().trim())


//    Api helper-it delivers our data to the api

            val helper = ApiHelper(applicationContext)
            helper.post(api, data)
        }






    }
}