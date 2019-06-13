package app.gladkikh.`fun`.catchsendsmspush.repository.db

import android.arch.lifecycle.LiveData
import app.gladkikh.`fun`.catchsendsmspush.App
import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage
import app.gladkikh.`fun`.catchsendsmspush.model.Repository

class DbHelper : Repository {
    override fun saveSms(message: SmsMessage) {
        Thread {
            App.database!!.smsDao().insert(message)

        }.start()
    }

    override fun getLiveDataListMessage(): LiveData<List<SmsMessage>> {
        return App.database!!.smsDao().getAll()
    }

}