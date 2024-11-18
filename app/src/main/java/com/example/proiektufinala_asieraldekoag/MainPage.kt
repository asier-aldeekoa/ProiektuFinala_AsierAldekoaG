package com.example.proiektufinala_asieraldekoag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NombreAdapter
    private lateinit var databaseHelper: SQL_User_Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        // Inicializar la base de datos
        databaseHelper = SQL_User_Database(this, "Altzairuen_Denda.db", null, 1)

        // Obtener la lista de productos desde la base de datos
        val produktuakList = databaseHelper.getProduktuak()

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NombreAdapter(produktuakList)
        recyclerView.adapter = adapter
    }
    //Una funcion que sobreescriba el menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    //Una funcion que sobreescriba la funcionpara q actuen nuestros botones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.altzariberria -> {
                val intent = Intent(this, ProductManagementActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            R.id.saioaitxi -> {
                Toast.makeText(this, "Saioa ITXI egin da", Toast.LENGTH_LONG).show()

                val intent1 = Intent(this, MainActivity::class.java)
                startActivity(intent1)

                finish()
                return true
            }
            R.id.irten -> {
                finishAffinity()
                System.exit(0)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}