package app.gladkikh.`fun`.catchsendsmspush.ui

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.EditText
import app.gladkikh.`fun`.catchsendsmspush.App.Companion.model
import app.gladkikh.`fun`.catchsendsmspush.R


class DialogSendSms : DialogFragment() {
    companion object {
        const val TAG = "DialogSendSms"

        fun newInstance(): DialogSendSms {
            return DialogSendSms()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = activity!!.layoutInflater.inflate(R.layout.dialog_sms, null)
        val edPhone = view.findViewById<EditText>(R.id.edPhone)
        val edMessage = view.findViewById<EditText>(R.id.edMessage)

        val builder = AlertDialog.Builder(activity!!)
            .setTitle("Send SMS")
            .setPositiveButton("OK") { dialog, _ ->

                model?.send(
                    phone = edPhone.text.toString(),
                    message = edMessage.text.toString()
                )

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        builder.setView(view)
        return builder.create()
    }

}