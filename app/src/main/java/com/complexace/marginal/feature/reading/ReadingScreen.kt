package com.complexace.marginal.feature.reading

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.complexace.marginal.core.model.Chapter
import com.complexace.marginal.core.model.Work

@Composable
fun ReadingScreen(viewModel: ReadingViewModel) {
    val state by viewModel.state.collectAsState()
    val chromeVisible by viewModel.chromeVisible.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { viewModel.toggleChrome() }
    ) {
        when (state) {
            is ReadingState.Loading -> LoadingView()
            is ReadingState.Error -> ErrorView((state as ReadingState.Error).message)
            is ReadingState.Success -> {
                val success = state as ReadingState.Success
                ReadingContent(
                    work = success.work,
                    chapter = success.chapter
                )
                if (chromeVisible) {
                    ReadingChrome(
                        work = success.work,
                        chapter = success.chapter,
                        onBack = { /* navigation — later */ }
                    )
                }
            }
        }
    }
}

@Composable
fun LoadingView() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message)
    }
}

@Composable
fun ReadingContent(work: Work, chapter: Chapter) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 80.dp)
    ) {
        item {
            Text(
                text = chapter.title,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
        items(chapter.paragraphs) { paragraph ->
            Text(
                text = paragraph.text,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun ReadingChrome(work: Work, chapter: Chapter, onBack: () -> Unit) {
    // Top and bottom bars — stub for now, styling next
    Box(Modifier.fillMaxSize()) {
        Text(
            text = "${work.title} · Ch ${chapter.index}",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 48.dp)
        )
    }
}