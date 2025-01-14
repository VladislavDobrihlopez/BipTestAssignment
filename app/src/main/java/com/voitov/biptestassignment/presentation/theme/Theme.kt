package com.voitov.biptestassignment.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private const val BLUE = 0xFF009FDB
private const val PRIMARY = 0xFF0A2FA7
private const val WHITE = 0xFFFFFFFF
private const val WHITE_TRANSPARENT = 0x80FFFFFF
private const val BLACK_TRANSPARENT = 0x08000000
private const val ON_PRIMARY_COLOR = 0xFF343138
const val PRIMARY_COLOR_4_60 = 0xFF788488
private const val PRIMARY_COLOR_4_70 = 0xFF616F74
private const val PRIMARY_CONTAINER = 0xFFF0F2F8
private const val SECONDARY_COLOR = 0xFF9DACDC
private const val OTHER_COLOR_GREY_6 = 0xFF788488
private const val DIVIDER_COLOR = 0xFFDBDEDF
private const val LIGHT_RED_COLOR = 0xFFFDD9D5
private const val LIGHT_RED_COLOR_2 = 0xFFF9E5EA
private const val DARK_RED_COLOR = 0xFFC70032
private const val HEADER_CONTAINER = 0xFFF6F6F6
private const val BLUE_COLOR_10 = 0xFFE5F5FB
private const val SHADOW_COLOR = 0x3F537C0F
private const val LIGHT_BLUE_BACKGROUND = 0xFFDEE4F8

private val lightColorScheme = lightColorScheme(
    primary = Color(PRIMARY),
    onPrimary = Color(WHITE),
    primaryContainer = Color(PRIMARY_CONTAINER),
    onPrimaryContainer = Color(ON_PRIMARY_COLOR),
    secondary = Color(SECONDARY_COLOR),
    onSecondary = Color(WHITE),
    secondaryContainer = Color(WHITE_TRANSPARENT),
    onSecondaryContainer = Color(PRIMARY),
    background = Color(WHITE),
    onBackground = Color(ON_PRIMARY_COLOR),
    surface = Color(WHITE),
    onSurface = Color(ON_PRIMARY_COLOR),
    onSurfaceVariant = Color(PRIMARY_COLOR_4_60),
    outlineVariant = Color(DIVIDER_COLOR),
    error = Color(DARK_RED_COLOR),
    onError = Color(WHITE),
    errorContainer = Color(LIGHT_RED_COLOR),
    onErrorContainer = Color(ON_PRIMARY_COLOR),
    outline = Color(OTHER_COLOR_GREY_6),
    tertiaryContainer = Color(HEADER_CONTAINER),
    inverseSurface = Color(BLUE_COLOR_10),
    inverseOnSurface = Color(ON_PRIMARY_COLOR),
    tertiary = Color(BLUE),
    onTertiary = Color(WHITE),
    onTertiaryContainer = Color(PRIMARY_COLOR_4_70)
)

@Composable
fun navigationItemsColors() =
    NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
        unselectedIconColor = MaterialTheme.colorScheme.secondary,
        unselectedTextColor = MaterialTheme.colorScheme.secondary,
        disabledIconColor = MaterialTheme.colorScheme.secondary,
        disabledTextColor = MaterialTheme.colorScheme.secondary,
    )

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun BipTestAssignmentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}