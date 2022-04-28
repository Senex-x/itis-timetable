package com.senex.timetable.presentation.common.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class ThemeSharedPrefsHandler @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveTheme(appTheme: AppTheme) = sharedPreferences.edit()
        .putString(PREF_THEME_KEY, appTheme.name)
        .apply()

    fun getSavedTheme() = AppTheme.valueOf(
        sharedPreferences.getString(
            PREF_THEME_KEY,
            AppTheme.LIGHT.name
        )!!
    )

    fun setOnThemeChangeListener(
        listener: (AppTheme) -> Unit,
    ) = sharedPreferences.registerOnSharedPreferenceChangeListener { _, key ->
        if (key == PREF_THEME_KEY) listener(getSavedTheme())
    }

    companion object {
        private const val PREF_THEME_KEY =
            "app_theme"
    }
}

