package com.example.testideaplatform.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.example.testideaplatform.presentation.screen.MainScreen
import com.example.testideaplatform.presentation.screen.view.TopBar
import com.example.testideaplatform.presentation.theme.Blue
import com.example.testideaplatform.presentation.viewmodel.MainViewModel
import com.example.testideaplatform.presentation.theme.TestIdeaPlatformTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Blue.toArgb(),
                Blue.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.auto(
                Blue.toArgb(),
                Blue.toArgb()
            )
        )

        setContent {
            TestIdeaPlatformTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() }
                ) { innerPadding ->
                    MainScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}