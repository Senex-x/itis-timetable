package com.senex.timetable.presentation.ui.settings

import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senex.timetable.presentation.common.prefs.DayNamesDisplayTypePrefs
import com.senex.timetable.presentation.common.prefs.LanguagePrefs
import com.senex.timetable.presentation.common.prefs.ThemeSharedPrefsHandler
import com.senex.timetable.presentation.common.prefs.constants.AppLanguage
import com.senex.timetable.presentation.common.prefs.constants.AppTheme
import com.senex.timetable.presentation.common.prefs.constants.DayNamesDisplayType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val themePrefsHandler: ThemeSharedPrefsHandler,
    private val dayNamesDisplayTypePrefs: DayNamesDisplayTypePrefs,
    private val languagePrefs: LanguagePrefs,
) : ViewModel() {

    private val _theme = MutableStateFlow(themePrefsHandler.getSavedTheme())
    val theme: StateFlow<AppTheme> = _theme

    init {
        theme.onEach {
            themePrefsHandler.saveTheme(it)

            AppCompatDelegate.setDefaultNightMode(
                when (it) {
                    AppTheme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
                    AppTheme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
                }
            )
        }.launchIn(viewModelScope)
    }

    fun setTheme(isLight: Boolean) {
        _theme.value = if (isLight) AppTheme.LIGHT else AppTheme.DARK
    }

    fun getDayNamesDisplayType() = dayNamesDisplayTypePrefs.getDisplayType()

    fun setDayNamesDisplayType(isFull: Boolean) = dayNamesDisplayTypePrefs.saveDisplayType(
        if (isFull) DayNamesDisplayType.FULL else DayNamesDisplayType.SHORT
    )

    fun getLanguage() = languagePrefs.getSavedLanguage()

    fun setLanguage(isRussian: Boolean, resources: Resources) {
        val appLanguage = if (isRussian) AppLanguage.RU else AppLanguage.EN
        languagePrefs.saveLanguage(appLanguage)

        setLocale(appLanguage.locale, resources)
    }

    private fun setLocale(locale: Locale, resources: Resources) {
        Locale.setDefault(locale)

        val overrideConfiguration = resources.configuration
        overrideConfiguration.setLocale(locale)
        resources.updateConfiguration(overrideConfiguration, resources.displayMetrics)
    }
}