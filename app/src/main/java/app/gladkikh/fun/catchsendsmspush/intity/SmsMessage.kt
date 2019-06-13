package app.gladkikh.`fun`.catchsendsmspush.intity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class SmsMessage(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    var phoneSender:String,
    var date:Long,
    var message:String
)