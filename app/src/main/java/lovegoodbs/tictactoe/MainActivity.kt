package lovegoodbs.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess
//пользуйся авто-форматированием (reformat file) - ctrl + alt + l
class MainActivity : AppCompatActivity() {
    //оставляй пустую строку между названием класса и методом
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //лучше использовать click listener - buttonView.setClickListener { startClick() }
    fun startClick(view: View) {
        //onStartClicked()
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }


    fun settingsClick(view: View) {
        //onSettingsClicked()
        //тут не нужна пустая строка
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    //и тут
    fun exitClick(view: View) {
        //onExitClicked()
        exitProcess(0)
    }
}