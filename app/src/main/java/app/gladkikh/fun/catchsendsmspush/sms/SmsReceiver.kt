package app.gladkikh.`fun`.catchsendsmspush.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import app.gladkikh.`fun`.catchsendsmspush.intity.SmsMessage
import app.gladkikh.`fun`.catchsendsmspush.model.Model
import java.util.*

class SmsReceiver : BroadcastReceiver() {
    private val model = Model()

    override fun onReceive(context: Context, intent: Intent?) {

        if (intent != null && intent.action != null) {

            // Получаем сообщения
            val pdus = intent.extras!!.get("pdus") as Array<*>
            val messages = arrayOfNulls<android.telephony.SmsMessage>(pdus.size)
            for (i in pdus.indices) {
                messages[i] = android.telephony.SmsMessage.createFromPdu(pdus[i] as ByteArray)
            }
            val smsFromPhone = messages[0]?.displayOriginatingAddress.toString()
            val body = StringBuilder()
            for (message in messages) {
                body.append(message?.messageBody)
            }

            model.saveSms(
                SmsMessage(
                    phoneSender = smsFromPhone,
                    message = body.toString(),
                    date = Date().time,
                    id = null
                )
            )

        }
    }
}