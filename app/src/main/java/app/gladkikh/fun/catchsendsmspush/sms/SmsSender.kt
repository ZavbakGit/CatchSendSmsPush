package app.gladkikh.`fun`.catchsendsmspush.sms

import android.telephony.SmsManager
import app.gladkikh.`fun`.catchsendsmspush.model.SendSms

class SmsSender:SendSms{
    private val smsManager = SmsManager.getDefault() as SmsManager

    override fun send(phone:String,message:String){
        smsManager.sendTextMessage(phone,
            null, message, null, null)
    }
}