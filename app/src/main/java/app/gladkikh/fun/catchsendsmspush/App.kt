package app.gladkikh.`fun`.catchsendsmspush

import android.app.Application
import android.arch.persistence.room.Room
import app.gladkikh.`fun`.catchsendsmspush.model.Model
import app.gladkikh.`fun`.catchsendsmspush.repository.db.AppDatabase


class App : Application() {
    companion object {
        var database: AppDatabase? = null
        var model:Model? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "mydatabase")
            .allowMainThreadQueries()
            .build()

        model = Model()

    }


}