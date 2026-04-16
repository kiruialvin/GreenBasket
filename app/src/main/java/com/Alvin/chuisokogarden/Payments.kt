package com.Alvin.chuisokogarden

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams
import kotlin.math.cos

class Payments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payments)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productname=intent.getStringExtra("product_name")
        val productcost=intent.getIntExtra("product_cost",0)
        val productphoto=intent.getStringExtra("product_photo")
        val productdescription=intent.getStringExtra("product_description")


//        find the views by their ids
        val Name = findViewById<TextView>(R.id.product_name)
        val Cost = findViewById<TextView>(R.id.product_cost)
        val photo = findViewById<ImageView>(R.id.product_photo)
        val phone = findViewById<EditText>(R.id.phone)
        val product_description=findViewById<TextView>(R.id.product_description)
        val purchase=findViewById<Button>(R.id.purchase)



//        sudo Chown -R $USER:$USER .

//        Update TextViews With Values Passed Via Intent
        Name.text=productname
        Cost.text="Ksh $productcost"
        product_description.text= productdescription


        Glide.with(this)
            .load(productphoto)
            .circleCrop()
            .into(photo)


        purchase.setOnClickListener {
//            set api Endpoint

            val api="https://kiruialvin.alwaysdata.net/api/mpesa_payment"

//            create data using Request params,put Phone and cost as keyvalue pairs
            val data= RequestParams()
            data.put("amount",productcost)
            data.put("phone",phone.text.toString())


//            Access Api helper

            val helper= ApiHelper(applicationContext)
//            post data to api endpoint
            helper.post(api,data)
        }

    }
}