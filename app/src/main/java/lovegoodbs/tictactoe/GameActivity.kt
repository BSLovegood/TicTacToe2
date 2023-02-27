package lovegoodbs.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import lovegoodbs.tictactoe.databinding.ActivityGameBinding

//го ViewModel заюзаем
class GameActivity : AppCompatActivity() {

    private val TAG: String = "gameActivity"
    //лучше так: private val TAG: String = GameActivity::class.java.simpleName и вне класса
    //тогда текст не нужно хардкодить

    private lateinit var binding: ActivityGameBinding
    private var currentPlayer: Int = 0
    //тут лучше использовать Enum
    private var gameActive: Boolean = true
    //boolean принято называть как: is, has, should, в данном случае isGameActive
    private var gameState: IntArray = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
    //лучше так: private var gameState2: IntArray = IntArray(9) { -1 }
    var winningPosition: Array<IntArray> = arrayOf(
        //winningPositions
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //empty line

    fun draw(view: View) {
        //binding.oneOne.setBackgroundResource(R.drawable.x2_icon)
        //binding.oneOne.alpha= 1.0F
        //в коде лучше не оставлять нерабочий код
        if (gameActive) {
            //можно чтобы большие вложенности не делать использовать early return
            //if (!isGameActive) return
            val ivClicked: ImageView = view as ImageView
            //переменная должна называться просто imageView, а не imageViewClicked, это же функция
            //переменная это существительное, функция глагол
            ivClicked.alpha = 1.0F
            val clickedImageView: Int = ivClicked.tag.toString().toInt()
            //опасно string просто так кастить в int, если кто то засунет туда текст будет падение
            //сделай safe cast
            //empty line

            if (gameState[clickedImageView] == -1 && gameActive) {
                //зачем проверять isGameActive здесь, ты бы сюда не попал если он был бы false
                //early return
                gameState[clickedImageView] = currentPlayer

                currentPlayer = if (currentPlayer == 0) {
                    ivClicked.setImageResource(R.drawable.xicon)
                    1
                } else {
                    ivClicked.setImageResource(R.drawable.o_icon)
                    //определись с правилами названия ресурсов, то xicon, то o_icon. Вообще используют "_" вместо пробела
                    0
                }
                //empty line
                //можно добавить небольшую оптимизацию, если на доске менее 5 заполненных ячеек, то игра не может закончится

                for (i in 0..7) {
                    //7 это хардкод, а это плохо, вынеси в константу
                    //и i тоже лучше назвать
                    if (gameState[winningPosition[i][0]] == gameState[winningPosition[i][1]] && gameState[winningPosition[i][1]] == gameState[winningPosition[i][2]] && gameState[winningPosition[i][2]] != -1) {
                        //пиздец конечно, постараяся не пересекать правую линию
                        //да и читать это не просто, может попробовать каждую проверку вынести в переменную и назвать осмысленно?
                        gameActive = false
                        if (gameState[winningPosition[i][0]] == 0)
                            //заюзай лучше toast или snackbar чтобы юзер видел что происходит
                            //логи неразраб не видит
                            Log.v(TAG, "Winner is X")
                        else (gameState[winningPosition[i][0]] == 1)
                            Log.v(TAG, "Winner is O")
                    }
                }
            }
        }
    }
}
