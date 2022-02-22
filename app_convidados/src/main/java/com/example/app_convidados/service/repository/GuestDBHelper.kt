package com.example.app_convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.app_convidados.service.constants.DBConstants

class GuestDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Convidados.db"

        private const val CREATE_TABLE_GUEST =
            ("create table " + DBConstants.GUEST.TABLE_NAME + " ("
                    + DBConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + DBConstants.GUEST.COLUMNS.NAME + " text, "
                    + DBConstants.GUEST.COLUMNS.PRESENCE + " integer);")

    }

}