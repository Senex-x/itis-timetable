package com.senex.timetable.presentation.common.prefs

import android.content.SharedPreferences
import com.senex.timetable.presentation.common.prefs.constants.AppLanguage
import com.senex.timetable.presentation.common.prefs.constants.AppTheme
import javax.inject.Inject

class LanguagePrefs @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveLanguage(appLanguage: AppLanguage) = sharedPreferences.edit()
        .putString(PREF_LANGUAGE_KEY, appLanguage.name)
        .apply()

    fun getSavedLanguage() = AppLanguage.valueOf(
        sharedPreferences.getString(
            PREF_LANGUAGE_KEY,
            AppLanguage.EN.name
        )!!
    )

    companion object {
        private const val PREF_LANGUAGE_KEY =
            "app_language"
    }
}

