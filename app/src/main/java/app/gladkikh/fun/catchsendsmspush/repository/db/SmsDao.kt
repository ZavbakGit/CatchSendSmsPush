package app.gladkikh.`fun`.catchsendsmspush.repository.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage

@Dao
interface SmsDao {
    @Query("SELECT * from SmsMessage")
    fun getAll(): LiveData<List<SmsMessage>>

    @Insert(onConflict = REPLACE)
    fun insert(message: SmsMessage)
}