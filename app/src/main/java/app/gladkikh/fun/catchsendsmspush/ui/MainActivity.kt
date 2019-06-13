package app.gladkikh.`fun`.catchsendsmspush.ui


import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import app.gladkikh.`fun`.catchsendsmspush.R
import app.gladkikh.`fun`.catchsendsmspush.modelview.MainActivityViewModel
import app.gladkikh.`fun`.catchsendsmspush.navigate.IRouter
import app.gladkikh.`fun`.catchsendsmspush.navigate.Router
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val permissionRequestCode = 123

    private val router: IRouter = Router(supportFragmentManager)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        fab.setOnClickListener {
            router.showSendSmsDialog()
        }

        val adapter = RecyclerViewAdapter(this)
        listRV.layoutManager = LinearLayoutManager(this)
        listRV.adapter = adapter


        val liveDataListMessage = viewModel.getLiveDataListSmsMessage()
        liveDataListMessage?.observe(this, Observer {
            if (it != null) {
                adapter.items = it
            } else {
                adapter.items = listOf()
            }
        })


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.RECEIVE_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissions = arrayOf(Manifest.permission.RECEIVE_SMS)
            ActivityCompat.requestPermissions(this, permissions, permissionRequestCode)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == permissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(fab, "Спасибо", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } else {
                Snackbar.make(
                    fab,
                    "Извините, апп без данного разрешения может работать неправильно",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action", null).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
