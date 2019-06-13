package app.gladkikh.`fun`.catchsendsmspush.modelview


import android.arch.lifecycle.ViewModel
import app.gladkikh.`fun`.catchsendsmspush.App.Companion.model

class MainActivityViewModel:ViewModel(){
    fun getLiveDataListSmsMessage() = model?.getLiveDataListMessage()

}