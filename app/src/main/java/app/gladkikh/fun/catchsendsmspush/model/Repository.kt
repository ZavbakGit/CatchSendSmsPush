package app.gladkikh.`fun`.catchsendsmspush.model

import android.arch.lifecycle.LiveData
import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage

interface Repository {
    fun getLiveDataListMessage():LiveData<List<SmsMessage>>
    fun saveSms(message:SmsMessage)
}