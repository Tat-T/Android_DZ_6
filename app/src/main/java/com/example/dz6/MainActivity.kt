package com.example.dz6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTargetMarker
import androidx.compose.ui.tooling.preview.Preview

import com.example.dz6.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

                }
            }
        }
    }

@Composable
fun AppScreen(){

}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
AppTheme {
    AppScreen()
    }
}
