package app.gladkikh.`fun`.catchsendsmspush.model
import app.gladkikh.`fun`.catchsendsmspush.repository.db.DbHelper
import app.gladkikh.`fun`.catchsendsmspush.sms.SmsSender

class Model:SendSms by SmsSender(),Repository by DbHelper()