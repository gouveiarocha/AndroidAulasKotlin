package com.example.app_convidados.service.repository

import android.content.Context

class GuestRepository private constructor(context: Context) {

    //Singleton Inicio ---->
    //Conceito resumido: A classe tem o construtor fechado, e somente um método estatico para retornar a instancia.
    //No caso abaixo, a instancia da classe está na variavel repository
//    private var mGuestDBHelper: GuestDBHelper = GuestDBHelper(context)
//
//    companion object {
//        private lateinit var repository: GuestRepository
//        fun getInstance(context: Context): GuestRepository {
//            if (!::repository.isInitialized) { //verificar se a variavel já foi inicializada.
//                repository = GuestRepository(context)
//            }
//            return repository
//        }
//    }
    //<---- Singleton fim.

//    private val dbWrite = mGuestDBHelper.writableDatabase
//    private val dbRead = mGuestDBHelper.readableDatabase

//    /**
//     * CRUDS
//     */
//
//    fun save(guest: GuestModelRoom): Boolean {
//        return try {
//            val contentValues = ContentValues()
//            contentValues.put(DBConstants.GUEST.COLUMNS.NAME, guest.name)
//            contentValues.put(DBConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
//            dbWrite.insert(DBConstants.GUEST.TABLE_NAME, null, contentValues)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    fun update(guest: GuestModelRoom): Boolean {
//        return try {
//            val contentValues = ContentValues()
//            contentValues.put(DBConstants.GUEST.COLUMNS.NAME, guest.name)
//            contentValues.put(DBConstants.GUEST.COLUMNS.PRESENCE, guest.presence)
//            val selection = DBConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(guest.id.toString())
//            dbWrite.update(DBConstants.GUEST.TABLE_NAME, contentValues, selection, args)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    fun delete(id: Int): Boolean {
//        return try {
//            val selection = DBConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(id.toString())
//            dbWrite.delete(DBConstants.GUEST.TABLE_NAME, selection, args)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    /**
//     * FILTERS
//     */
//
//    fun get(id: Int): GuestModelRoom? {
//        var guest: GuestModel? = null
//        return try {
//            //usando rawquery - menos seguro
//            //val cursor = dbRead.rawQuery("select * from ${DBConstants.GUEST.TABLE_NAME} where id = $id", null)
//            val projection = arrayOf(
//                DBConstants.GUEST.COLUMNS.NAME,
//                DBConstants.GUEST.COLUMNS.PRESENCE
//            )
//
//            val selection = DBConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(id.toString())
//
//            val cursor = dbRead.query(
//                DBConstants.GUEST.TABLE_NAME,
//                projection,
//                selection,
//                args,
//                null,
//                null,
//                null
//            )
//
//            if (cursor != null && cursor.count > 0) {
//                cursor.moveToFirst()
//
//                val name = cursor.getString(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.NAME))
//                val presence =
//                    (cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.PRESENCE)) == 1)
//
//                guest = GuestModel(id, name, presence)
//            }
//
//            cursor?.close()
//
//            guest
//
//        } catch (e: Exception) {
//            guest
//        }
//    }
//
//    fun getAll(): List<GuestModelRoom> {
//        val guestList: MutableList<GuestModel> = ArrayList()
//        try {
//            val projection = arrayOf(
//                DBConstants.GUEST.COLUMNS.ID,
//                DBConstants.GUEST.COLUMNS.NAME,
//                DBConstants.GUEST.COLUMNS.PRESENCE
//            )
//
//            val cursor = dbRead.query(
//                DBConstants.GUEST.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                null
//            )
//
//            if (cursor != null && cursor.count > 0) {
//                while (cursor.moveToNext()) {
//                    val id = cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.ID))
//                    val name = cursor.getString(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.NAME))
//                    val presence = (cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.PRESENCE)) == 1)
//
//                    val guest = GuestModel(id, name, presence)
//                    guestList.add(guest)
//
//                }
//
//            }
//
//            cursor?.close()
//
//            return guestList
//
//        } catch (e: Exception) {
//            return guestList
//        }
//    }
//
//    fun getPresent(): List<GuestModelRoom> {
//        val guestList: MutableList<GuestModel> = ArrayList()
//        try {
//            val cursor = dbRead.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 1", null)
//
//            if (cursor != null && cursor.count > 0) {
//                while (cursor.moveToNext()) {
//
//                    val id = cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.ID))
//                    val name = cursor.getString(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.NAME))
//                    val presence = (cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.PRESENCE)) == 1)
//
//                    val guest = GuestModel(id, name, presence)
//                    guestList.add(guest)
//
//                }
//            }
//
//            cursor?.close()
//
//            return guestList
//
//        } catch (e: Exception) {
//            return guestList
//        }
//    }
//
//    fun getAbsents(): List<GuestModelRoom> {
//        val guestList: MutableList<GuestModel> = ArrayList()
//        try {
//            val cursor = dbRead.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 0", null)
//
//            if (cursor != null && cursor.count > 0) {
//                while (cursor.moveToNext()) {
//
//                    val id = cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.ID))
//                    val name = cursor.getString(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.NAME))
//                    val presence = (cursor.getInt(cursor.getColumnIndex(DBConstants.GUEST.COLUMNS.PRESENCE)) == 1)
//
//                    val guest = GuestModel(id, name, presence)
//                    guestList.add(guest)
//
//                }
//            }
//
//            cursor?.close()
//
//            return guestList
//
//        } catch (e: Exception) {
//            return guestList
//        }
//    }

}