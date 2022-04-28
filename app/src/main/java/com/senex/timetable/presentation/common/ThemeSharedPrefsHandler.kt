package com.senex.timetable.presentation.common

import android.content.SharedPreferences
import javax.inject.Inject

class ThemeSharedPrefsHandler @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveTheme(theme: Theme) = sharedPreferences.edit()
        .putString(PREF_THEME_KEY, theme.name)
        .apply()

    fun getSavedTheme() = Theme.valueOf(
        sharedPreferences.getString(
            PREF_THEME_KEY,
            Theme.LIGHT.name
        )!!
    )

    companion object {
        private const val PREF_THEME_KEY =
            "app_theme"
    }
}

enum class Theme {
    LIGHT,
    DARK,
}