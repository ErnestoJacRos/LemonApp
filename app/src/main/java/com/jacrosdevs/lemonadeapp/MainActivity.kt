package com.jacrosdevs.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jacrosdevs.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                LemonApp()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LemonApp() {
    LemonadeIamgesAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeIamgesAndText(
    modifier: Modifier = Modifier

) {
    Text(
        text = "Lemonade",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var result by remember {
            mutableStateOf(1)
        }
        val imageResource = when(result) {
            1 -> R.drawable.lemon_tree
            in 2..4 -> R.drawable.lemon_squeeze
            5 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val stringResource = when( result) {
            1 -> R.string.tree_select_text
            in 2..4 -> R.string.squeeze_text
            5 -> R.string.drink_text
            else -> R.string.empty_glass_text
        }

        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier.clickable { if(result < 6) result++ else result = 1 }
                .background(Color.LightGray)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = stringResource),
            fontSize = 18.sp
        )
        /*Button(onClick = { result = (1..5).random() }) {
            Text(text = "press")
        }*/
    }
}


