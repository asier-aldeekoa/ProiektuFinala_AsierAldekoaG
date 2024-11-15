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
        db.execSQL("""CREATE TABLE erabiltzaileak(id INTEGER PRIMARY KEY AUTOINCREMENT,erabiltzailea TEXT,posta TEXT,
            pass TEXT,generoa TEXT)""")

        db.execSQL("""CREATE TABLE produktuak(id INTEGER PRIMARY KEY AUTOINCREMENT,altzariIzena TEXT,altzariMota TEXT,
            materiales TEXT,dimentsioak TEXT,prezioa REAL,stock INTEGER)""")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL("DROP TABLE IF EXISTS erabiltzaileak")
            db.execSQL("DROP TABLE IF EXISTS produktuak")
            onCreate(db)
        }
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

    fun produktuGehitu(altzariIzena: String, altzariMota: String, materiales: String,
                       dimentsioak: String, prezioa: Double, stock: Int): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("altzariIzena", altzariIzena)
            put("altzariMota", altzariMota)
            put("materiales", materiales)
            put("dimentsioak", dimentsioak)
            put("prezioa", prezioa)
            put("stock", stock)
        }
        return db.insert("produktuak", null, values)
    }
}