package app.gladkikh.`fun`.catchsendsmspush.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage


@Database(entities = [SmsMessage::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun smsDao(): SmsDao
}