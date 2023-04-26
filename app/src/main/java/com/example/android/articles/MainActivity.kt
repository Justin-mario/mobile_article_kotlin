package com.example.android.articles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.articles.ui.theme.ArticlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article(title = stringResource(R.string.title),
                        paragraphOne = stringResource(R.string.paragraph_one),
                        paragraphTwo = stringResource(R.string.paragraph_two))
                }
            }
        }
    }
}


@Composable
fun Article(title: String, paragraphOne: String, paragraphTwo: String){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(
        modifier = Modifier.background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        ){
        Image(
            painter = image,
            contentDescription = null,
        contentScale = ContentScale.FillWidth
        )
        Text(text = title, fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Yellow))
        Text(text = paragraphOne,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Text(text = paragraphTwo,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
            )
    }

}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticlesTheme {
        Article(title = stringResource(R.string.title),
            paragraphOne = stringResource(R.string.paragraph_one),
            paragraphTwo = stringResource(R.string.paragraph_two))
    }
}