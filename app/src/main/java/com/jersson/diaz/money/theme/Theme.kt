package com.jersson.diaz.money.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val accountDetail = TextStyle(
    color = neutralsSky500,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.Normal
)

val accountAmountDetail = TextStyle(
    color = neutralsSky500,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.Bold
)

val accountDateDetail = TextStyle(
    color = neutralsSky500,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    fontWeight = FontWeight.Normal
)

val accountHeadboard = TextStyle(
    color = neutralsSky500,
    fontSize = 24.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.Bold
)