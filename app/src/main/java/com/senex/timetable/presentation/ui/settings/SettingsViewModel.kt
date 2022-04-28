package com.senex.timetable.presentation.ui.settings

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senex.timetable.presentation.common.prefs.AppTheme
import com.senex.timetable.presentation.common.prefs.ThemeSharedPrefsHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val themePrefsHandler: ThemeSharedPrefsHandler,
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
        _theme.value = if (isLight)
            AppTheme.LIGHT
        else
            AppTheme.DARK
    }
}