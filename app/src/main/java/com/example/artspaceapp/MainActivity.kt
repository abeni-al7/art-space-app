package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .verticalScroll(state = rememberScrollState())
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace( modifier: Modifier = Modifier) {
    var page by remember { mutableStateOf(1) }
    var image = when (page) {
        1 -> R.drawable.oip
        2 -> R.drawable.oip_1
        else -> R.drawable.r
    }
    var title = when (page) {
        1 -> R.string.artwork_title_1
        2 -> R.string.artwork_title_2
        else -> R.string.artwork_title_3
    }
    var artist = when (page) {
        1 -> R.string.artwork_artist_1
        2 -> R.string.artwork_artist_2
        else -> R.string.artwork_artist_3
    }
    var year = when (page) {
        1 -> R.string.artwork_year_1
        2 -> R.string.artwork_year_2
        else -> R.string.artwork_year_3
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 30.dp)
    ) {
        Surface (
            tonalElevation = 16.dp,
            shadowElevation = 16.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            border = BorderStroke(32.dp, Color.White),
        ) {
            Image(
                painterResource(image),
                contentDescription = "Web design",
            )
        }

        Spacer(Modifier.height(64.dp))

        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(title),
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = buildAnnotatedString {
                        pushStyle(
                            SpanStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        append(stringResource(artist))
                        pop()
                        pushStyle(
                            SpanStyle(
                                fontSize = 12.sp
                            )
                        )
                        append(" (")
                        append(stringResource(year))
                        append(")")
                    }
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    if (page > 1) {
                        page--
                    } else {
                        page = 1
                    }
                },
                colors = ButtonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.White
                ),
                modifier = Modifier.width(140.dp),
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if (page < 3) {
                        page++
                    } else {
                        page = 1
                    }
                },
                colors = ButtonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                    disabledContainerColor = Color.DarkGray,
                    disabledContentColor = Color.White
                ),
                modifier = Modifier.width(140.dp),
            ) {
                Text(text = "Next")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}