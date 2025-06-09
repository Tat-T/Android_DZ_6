package com.example.dz6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.dz6.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                AppScreenPreview()
                }
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen(){
    var text by remember { mutableStateOf("") }
    var showEditDialog by remember { mutableStateOf(false) }
    var tempText by remember {mutableStateOf("")}
    var context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
            title = { Text("Demo App") },
                actions = {
                    IconButton(onClick = { showEditDialog = true}) {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Edit text")
                    }
                    IconButton(onClick = {
                        if (text.isNotEmpty()) {
                            android.widget.Toast.makeText(
                                context,
                                text,
                                android.widget.Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                        enabled = text.isNotEmpty()
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Show notification"
                        )
                    }
                }
            )
        })
    { paddingValues ->
        Box(
            modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (text.isEmpty()) "No text entered..." else text,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = {showEditDialog = false},
            title = {"Edit text"},
            text = { OutlinedTextField(
                value = tempText,
                onValueChange = { tempText = it},
                label = {Text("Enter notification message")},
                modifier = Modifier.fillMaxWidth()
            )
            },
            confirmButton = {
                TextButton(onClick = {
                text = tempText
                showEditDialog = false
            })  { Text("Ok") }
                            },
            dismissButton = { TextButton(onClick = { showEditDialog = false }) { Text("CANCEL") }}
            )
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreenPreview(){
AppTheme {
    AppScreen()
    }
}
