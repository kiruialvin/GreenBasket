package com.Alvin.chuisokogarden

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class About : AppCompatActivity() {
//    declare a tts variable
    lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textview=findViewById<TextView>(R.id.textview)
        val inputText= findViewById<EditText>(R.id.inputText)
        val speakButton=findViewById<Button>(R.id.speakButton)

//        create a TTs object.check if tts is available and set language

        tts= TextToSpeech(this){
            if (it== TextToSpeech.SUCCESS){
                tts.language= Locale.US
            }

        }

//        set button listener

        speakButton.setOnClickListener {
            val textt=inputText.text.toString()
            tts.speak(textt, TextToSpeech.QUEUE_FLUSH,null,null)

//            val userInput= inputText.text.tostring()
//            val textToSpeak=if (userInput.isNotEmpty()){
//                userInput
//            }else{
////                abouttext.text.tostring()
        }
    }
//    stop the tts from speaking when app is closed/destroyed/killed
    override fun onDestroy() {
        tts.stop()
        tts.shutdown()
        super.onDestroy()
    }
}