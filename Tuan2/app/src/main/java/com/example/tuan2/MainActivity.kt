package com.example.tuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapTuan2App()
        }
    }
}

@Composable
fun BaiTapTuan2App() {
    var name by remember { mutableStateOf("") }
    var ageText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("THỰC HÀNH 01", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Họ và tên") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = ageText,
            onValueChange = { ageText = it },
            label = { Text("Tuổi") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val age = ageText.toIntOrNull()
            result = if (age == null || name.isBlank()) {
                "Vui lòng nhập đúng thông tin!"
            } else {
                when {
                    age <= 2 -> "$name là Em bé"
                    age in 3..6 -> "$name là Trẻ em"
                    age in 7..65 -> "$name là Người lớn"
                    else -> "$name là Người già"
                }
            }
        }) {
            Text("Kiểm tra")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = result,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    BaiTapTuan2App()
}
