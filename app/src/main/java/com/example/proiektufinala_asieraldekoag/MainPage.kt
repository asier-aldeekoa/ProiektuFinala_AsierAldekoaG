package com.example.proiektufinala_asieraldekoag

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
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
            R.id.altzarizerrenda -> {
                Toast.makeText(this,"Ireki botoia sakatu da",Toast.LENGTH_LONG )
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