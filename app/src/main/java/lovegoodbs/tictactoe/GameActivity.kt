package lovegoodbs.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import lovegoodbs.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private var currentPlayer:Int=0
    private var gameActive:Boolean=true
    private var gameState: IntArray = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
    var winningPosition: Array<IntArray> = arrayOf(intArrayOf(0,1,2),intArrayOf(3,4,5),intArrayOf(6,7,8),intArrayOf(0,3,6),intArrayOf(1,4,7),intArrayOf(2,5,8),intArrayOf(0,4,8),intArrayOf(2,4,6))
    var winner="x"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun draw(view: View) {
       //binding.oneOne.setBackgroundResource(R.drawable.x2_icon)
        //binding.oneOne.alpha= 1.0F

        val ivClicked:ImageView=view as ImageView
        ivClicked.alpha=1.0F
        val clickedImageView:Int= ivClicked.tag.toString().toInt()

        ivClicked.isVisible

        if(gameState[clickedImageView]==-1 && gameActive)
        {
            gameState[clickedImageView]=currentPlayer

            currentPlayer = if(currentPlayer==0) {
                ivClicked.setImageResource(R.drawable.xicon)
                1
            } else{
                ivClicked.setImageResource(R.drawable.o_icon)
                0
            }
        }

        ivClicked.isVisible



    }
}
