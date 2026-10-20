package tw.edu.pu.csim.s1141237.rolldice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tw.edu.pu.csim.s1141237.rolldice.ui.theme.RollDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RollDiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dice(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dice(modifier: Modifier = Modifier) {
    var diceNumber by remember { mutableStateOf(0) }
    val diceImages = listOf(
        R.drawable.dice0, // 索引 0
        R.drawable.dice1, // 索引 1
        R.drawable.dice2, // 索引 2
        R.drawable.dice3, // 索引 3
        R.drawable.dice4, // 索引 4
        R.drawable.dice5, // 索引 5
        R.drawable.dice6  // 索引 6
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("請點擊圖片隨機丟骰子\n作者：陳柏睿")

        Spacer(modifier = Modifier. height(20.dp))

        Image(
            painter = painterResource(id = diceImages[diceNumber]),
            contentDescription = "Dice",
            modifier = Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    // 單擊：產生 1 到 6 的隨機整數
                                    diceNumber = (1..6).random()
                                },
                                onDoubleTap = {
                                    // 雙擊：重置為 0 (回到 dice0)
                                    diceNumber = 0
                                }
                            )


                })
    }
}
