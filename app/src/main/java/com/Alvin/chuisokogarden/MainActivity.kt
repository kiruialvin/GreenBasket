package com.Alvin.chuisokogarden

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val signup=findViewById<Button>(R.id.signup)
//        click listener
        signup.setOnClickListener {
            val signupIntent= Intent(applicationContext, SignUp::class.java)
            startActivity(signupIntent)

        }
        val signIn=findViewById<Button>(R.id.signIn)
//        click listener
        signIn.setOnClickListener {
            val signInIntent= Intent(applicationContext, SignIn::class.java)
            startActivity(signInIntent)

        }

        val progressbar=findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)



        val api="https://kiruialvin.alwaysdata.net/api/getproductdetails"

        val helper= ApiHelper(applicationContext)
        helper.loadProducts(api,recyclerView,progressbar)

    }
}