package com.example.proiektufinala_asieraldekoag

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProductManagementActivity : AppCompatActivity() {
    lateinit var AltzariIzena: EditText
    lateinit var AltzriMota: Spinner
    lateinit var chkEgurra: CheckBox
    lateinit var chkMetala: CheckBox
    lateinit var chkPlastikoa: CheckBox
    lateinit var chkKristala: CheckBox
    lateinit var chkHarria: CheckBox
    lateinit var chkLarrua: CheckBox
    lateinit var Dimentsioak: EditText
    lateinit var Prezioa: EditText
    lateinit var chkStock: CheckBox
    lateinit var GehituButton: Button
    lateinit var dbHelper: SQL_User_Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_management)

        AltzariIzena = findViewById(R.id.txtIzena)
        AltzriMota = findViewById(R.id.spinner)
        chkEgurra= findViewById(R.id.checkBox)
        chkMetala = findViewById(R.id.checkBox2)
        chkPlastikoa = findViewById(R.id.checkBox3)
        chkKristala = findViewById(R.id.checkBox4)
        chkHarria = findViewById(R.id.checkBox5)
        chkLarrua = findViewById(R.id.checkBox6)
        Dimentsioak = findViewById(R.id.txtDimentsioak)
        Prezioa = findViewById(R.id.txtPrezioa)
        chkStock = findViewById(R.id.chkStock)
        GehituButton = findViewById(R.id.btnAltzariGehitu)

        dbHelper = SQL_User_Database(this, "Altzairuen_Denda.db", null, 1)

        //Valores del SPINNER
        val AltzariAukerak = arrayOf("Sofa" , "Mahaia" , "Aulkia" , "Ohea" , "Armairua" , "Bankua" , "Ispilua" , "Besaulkia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, AltzariAukerak)
        AltzriMota.setAdapter(adapter)

        GehituButton.setOnClickListener(){
            GehituProd()
        }
    }
    fun GehituProd() {
        val altzariIzena = AltzariIzena.text.toString()
        val altzariMota = AltzriMota.selectedItem.toString()

        // Recoger los materiales seleccionados
        val materiales = mutableListOf<String>()
        if (chkEgurra.isChecked) materiales.add("Egurra")
        if (chkMetala.isChecked) materiales.add("Metala")
        if (chkPlastikoa.isChecked) materiales.add("Plastikoa")
        if (chkKristala.isChecked) materiales.add("Kristala")
        if (chkHarria.isChecked) materiales.add("Harria")
        if (chkLarrua.isChecked) materiales.add("Larrua")
        val materialesString = materiales.joinToString(", ")

        val dimentsioak = Dimentsioak.text.toString()
        val prezioa = Prezioa.text.toString().toDoubleOrNull() ?: 0.0
        val stock = if (chkStock.isChecked) 1 else 0  // 1 si hay stock, 0 si no

        // Llamada a la función para insertar el producto en la base de datos
        val resultado = dbHelper.produktuGehitu(altzariIzena, altzariMota, materialesString, dimentsioak, prezioa, stock)

        if (resultado != -1L) {
            Toast.makeText(this, "Produktu berria gehitu da :)", Toast.LENGTH_SHORT).show()

            // Intent para redirigir a la MainActivity
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Errorea produktua gehitzean", Toast.LENGTH_SHORT).show()
        }
    }
}