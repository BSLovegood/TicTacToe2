package lovegoodbs.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }


    fun settingsClick(view: View) {

        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }


    fun exitClick(view: View) {
        exitProcess(0)
    }
}