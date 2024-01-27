package com.example.koincrashmre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.koincrashmre.ui.theme.KoinCrashMRETheme
import org.koin.android.ext.koin.androidContext
import org.koin.compose.koinInject
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidContext(this@MainActivity)
            modules(module)
        }
        setContent {
            KoinCrashMRETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val testDIClass: TestDIClass = koinInject() // problem
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
