package com.example.proiektufinala_asieraldekoag

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var PostaElektronikoa: EditText
    lateinit var Pasahitza: EditText
    lateinit var Login: Button
    lateinit var Erregistratu: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        val screemSplash=installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //HASIERAKETAK
        PostaElektronikoa = findViewById(R.id.txtPosta)
        Pasahitza = findViewById(R.id.txtPass)
        Login = findViewById(R.id.btnLogin)
        Erregistratu = findViewById(R.id.btnErregistratu)

        Login.setOnClickListener(){
            Logeatu()
        }
        Erregistratu.setOnClickListener(){
            Erregistroa()
        }
        screemSplash.setKeepOnScreenCondition{ false }
    }
    fun Logeatu() {
    }
    fun Erregistroa() {
        val intent = Intent(this, ErregistroOrria::class.java)
        startActivity(intent)
    }
}