package com.example.app_convidados.service.repository

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class GuestDatabase : RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: GuestDatabase
        fun getDatabase(context: Context): GuestDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guestDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }

}