package app.gladkikh.`fun`.catchsendsmspush.navigate

import android.support.v4.app.FragmentManager
import app.gladkikh.`fun`.catchsendsmspush.ui.DialogSendSms

class Router(private val fragmentManager: FragmentManager): IRouter {
    override fun showSendSmsDialog() {
       DialogSendSms.newInstance().show(fragmentManager,DialogSendSms.TAG)
    }
}