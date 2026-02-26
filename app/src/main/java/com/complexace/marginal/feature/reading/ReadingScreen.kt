package com.complexace.marginal.feature.reading

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.complexace.marginal.core.model.Chapter
import com.complexace.marginal.core.model.Work
import com.complexace.marginal.ui.theme.Accent
import com.complexace.marginal.ui.theme.TextDim
import com.complexace.marginal.ui.theme.TextSecondary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*

@Composable
fun ReadingScreen(viewModel: ReadingViewModel) {
    val state by viewModel.state.collectAsState()
    val chromeVisible by viewModel.chromeVisible.collectAsState()
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .clickable(interactionSource = interactionSource, indication = null) {
                viewModel.toggleChrome()
            }
    ) {
        when (state) {
            is ReadingState.Loading -> LoadingView()
            is ReadingState.Error -> ErrorView((state as ReadingState.Error).message)
            is ReadingState.Success -> {
                val success = state as ReadingState.Success

                Column(modifier = Modifier.fillMaxSize()) {
                    ReadingContent(
                        work = success.work,
                        chapter = success.chapter,
                        chromeVisible = chromeVisible,
                        modifier = Modifier.weight(1f)
                    )
                    ProgressBar()
                }

                AnimatedVisibility(
                    visible = chromeVisible,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    ReadingChrome(
                        work = success.work,
                        chapter = success.chapter,
                        onBack = { }
                    )
                }
            }
        }
    }
}

@Composable
fun ReadingContent(work: Work, chapter: Chapter, chromeVisible: Boolean, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            start = 24.dp,
            end = 24.dp,
            top = if (chromeVisible) 110.dp else 80.dp,
            bottom = 24.dp
        )
    ) {
        item {
            // Chapter label
            Text(
                text = "Chapter ${chapter.index}".uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = TextDim,
                letterSpacing = 2.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Chapter title
            Text(
                text = chapter.title,
                style = MaterialTheme.typography.titleMedium,
                color = TextSecondary,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }
        // Author note if present
        chapter.authorNote?.let { note ->
            item {
                Text(
                    text = note,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary,
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .padding(start = 12.dp)
                )
            }
        }
        items(chapter.paragraphs) { paragraph ->
            Text(
                text = paragraph.text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun ProgressBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(TextDim)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.34f)
                    .background(Accent)
            )
        }
        Text(
            text = "34% · 6 min",
            style = MaterialTheme.typography.labelSmall,
            color = TextSecondary
        )
    }
}

@Composable
fun ReadingChrome(work: Work, chapter: Chapter, onBack: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .background(
                    androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            Color.Transparent
                        )
                    )
                )
                .padding(horizontal = 16.dp)
                .padding(top = 48.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = TextSecondary
                )
            }

            // Title + author
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = work.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "by ${work.author}",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextSecondary
                )
            }

            // Action icons
            Row {
                IconButton(onClick = { /* positional bookmark */ }) {
                    Icon(
                        imageVector = Icons.Filled.Bookmark,
                        contentDescription = "Save position",
                        tint = TextSecondary
                    )
                }
                IconButton(onClick = { /* fic bookmark */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Add to library",
                        tint = TextSecondary
                    )
                }
                IconButton(onClick = { /* comments */ }) {
                    Icon(
                        imageVector = Icons.Filled.Comment,
                        contentDescription = "Comments",
                        tint = TextSecondary
                    )
                }
                IconButton(onClick = { /* settings */ }) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                        tint = TextSecondary
                    )
                }
            }
        }

        // Bottom bar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp, top = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "← Prev",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextSecondary
                )
                Text(
                    text = "Ch ${chapter.index} / ${work.chapterIds.size}",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextSecondary
                )
                Text(
                    text = "Next →",
                    style = MaterialTheme.typography.labelMedium,
                    color = TextSecondary
                )
            }
        }
    }
}

@Composable
fun LoadingView() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = Accent)
    }
}

@Composable
fun ErrorView(message: String) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, color = TextSecondary)
    }
}