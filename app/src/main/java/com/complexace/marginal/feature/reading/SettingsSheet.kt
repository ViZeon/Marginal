package com.complexace.marginal.feature.reading

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.complexace.marginal.core.AppSettings
import com.complexace.marginal.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsSheet(onDismiss: () -> Unit) {
    val currentTheme by AppSettings.theme.collectAsState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Theme section
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "THEME",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextDim,
                    letterSpacing = androidx.compose.ui.unit.TextUnit(2f, androidx.compose.ui.unit.TextUnitType.Sp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    ThemeSwatch(
                        label = "OLED",
                        background = Color.Black,
                        textColor = Color(0xFF555555),
                        selected = currentTheme == AppTheme.OLED,
                        modifier = Modifier.weight(1f)
                    ) { AppSettings.setTheme(AppTheme.OLED) }

                    ThemeSwatch(
                        label = "Dark",
                        background = Color(0xFF1A1A1A),
                        textColor = Color(0xFF888888),
                        selected = currentTheme == AppTheme.DARK,
                        modifier = Modifier.weight(1f)
                    ) { AppSettings.setTheme(AppTheme.DARK) }

                    ThemeSwatch(
                        label = "Light",
                        background = Color(0xFFF0ECE4),
                        textColor = Color(0xFF999690),
                        selected = currentTheme == AppTheme.LIGHT,
                        modifier = Modifier.weight(1f)
                    ) { AppSettings.setTheme(AppTheme.LIGHT) }
                }
            }

            // Font size section
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text(
                    text = "FONT SIZE",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextDim,
                    letterSpacing = androidx.compose.ui.unit.TextUnit(2f, androidx.compose.ui.unit.TextUnitType.Sp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Decrease
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.background)
                            .border(1.dp, Color(0xFF222222), RoundedCornerShape(10.dp))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("A−", color = TextSecondary, style = MaterialTheme.typography.labelMedium)
                    }

                    // Preview
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Aa", color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.bodyLarge)
                    }

                    // Increase
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.background)
                            .border(1.dp, Color(0xFF222222), RoundedCornerShape(10.dp))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Text("A+", color = TextSecondary, style = MaterialTheme.typography.labelMedium)
                    }
                }
            }
        }
    }
}

@Composable
fun ThemeSwatch(
    label: String,
    background: Color,
    textColor: Color,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(background)
            .border(
                width = if (selected) 1.5.dp else 1.dp,
                color = if (selected) Accent else Color(0xFF222222),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = textColor, style = MaterialTheme.typography.labelSmall)
    }
}