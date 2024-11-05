package com.example.proiektufinala_asieraldekoag

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ErregistroOrria : AppCompatActivity() {
    lateinit var Erabiltzailea: EditText
    lateinit var PostaElektronikoa: EditText
    lateinit var Pasahitza: EditText
    lateinit var Gizona: RadioButton
    lateinit var Emakumea: RadioButton
    lateinit var Bestea: RadioButton
    lateinit var Adina: CheckBox
    lateinit var EgoitzaSpinner: Spinner
    lateinit var Erregistratu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erregistro_orria)
        //HASIERAKETAK
        Erabiltzailea = findViewById(R.id.txtErab)
        PostaElektronikoa= findViewById(R.id.txtPosta)
        Pasahitza= findViewById(R.id.txtPass)
        Gizona = findViewById(R.id.btnGizona)
        Emakumea = findViewById(R.id.btnEmakumea)
        Bestea = findViewById(R.id.btnBestea)
        Adina = findViewById(R.id.chkAdina)
        EgoitzaSpinner = findViewById(R.id.spnEgoitza)
        Erregistratu = findViewById(R.id.btnErregistroa)





    }
}