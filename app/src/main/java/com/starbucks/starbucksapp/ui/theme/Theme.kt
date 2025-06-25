package com.starbucks.starbucksapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define Light Color Scheme
private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    primaryContainer = PrimaryVariantColor,
    onPrimary = OnPrimaryColor,
    secondary = SecondaryColor,
    secondaryContainer = StarbucksGold, // Can be same as secondary or a lighter/darker shade
    onSecondary = OnSecondaryColor,
    tertiary = AccentYellow,
    background = BackgroundColor,
    onBackground = OnBackgroundColor,
    surface = SurfaceColor,
    onSurface = OnSurfaceColor,
    error = ErrorColor,
    onError = OnErrorColor,
    // Add other colors as needed for a complete theme
    surfaceVariant = GrayBackground, // Used for cards, elevated surfaces
    onSurfaceVariant = TextDark,
    outline = DividerColor, // Used for borders
)

// Define Dark Color Scheme (Optional, but good for dark mode support)
private val DarkColorScheme = darkColorScheme(
    primary = StarbucksGreenLight, // Lighter green for dark mode primary
    primaryContainer = StarbucksGreen,
    onPrimary = TextDark,
    secondary = StarbucksGold,
    secondaryContainer = StarbucksGold,
    onSecondary = TextLight,
    tertiary = AccentYellow,
    background = Color(0xFF121212), // Dark background
    onBackground = TextLight,
    surface = Color(0xFF1E1E1E), // Dark surface
    onSurface = TextLight,
    error = ErrorRed,
    onError = TextLight,
    surfaceVariant = Color(0xFF2C2C2C),
    onSurfaceVariant = TextLight,
    outline = Color(0xFF424242),
)

@Composable
fun StarbucksCloneTheme( // Consider renaming this to StarbucksAppTheme as well, if applicable
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, // Set to true to enable dynamic theming based on wallpaper
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Set status bar color
            window.statusBarColor = colorScheme.primary.toArgb()
            // Adjust status bar icons for light/dark theme
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Our custom typography
        content = content
    )
}