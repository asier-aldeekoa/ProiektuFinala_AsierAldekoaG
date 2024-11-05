package com.example.proiektufinala_asieraldekoag

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

public class SQL_User_Database (
    context:Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE erabiltzaileak( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "erabiltzailea TEXT, " + "posta TEXT, " + "pass TEXT, " + "generoa TEXT)"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun erabiltzaileaSartu(erabiltzailea: String, posta: String, pass: String, generoa: String): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("erabiltzailea", erabiltzailea)
            put("posta", posta)
            put("pass", pass)
            put("generoa", generoa)
        }

        return db.insert("erabiltzaileak", null, values)
    }
}