package com.complexace.marginal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.complexace.marginal.core.MockConnector
import com.complexace.marginal.core.PlatformRegistry
import com.complexace.marginal.core.model.Platform
import com.complexace.marginal.feature.reading.ReadingScreen
import com.complexace.marginal.feature.reading.ReadingViewModel
import com.complexace.marginal.repository.MarginalRepository
import com.complexace.marginal.ui.theme.MarginalTheme

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.complexace.marginal.core.AppSettings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PlatformRegistry.register(
            Platform("mock", "Mock"),
            MockConnector()
        )

        val connector = PlatformRegistry.getConnector("mock")!!
        val repository = MarginalRepository(connector)

        enableEdgeToEdge()
        setContent {
            val appTheme by AppSettings.theme.collectAsState()
            MarginalTheme(appTheme = appTheme) {
                Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                    val viewModel: ReadingViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                @Suppress("UNCHECKED_CAST")
                                return ReadingViewModel(repository) as T
                            }
                        }
                    )
                    viewModel.load("mock://work", "mock://chapter")
                    ReadingScreen(viewModel = viewModel)
                }
            }
        }
    }
}