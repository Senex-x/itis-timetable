package com.senex.timetable.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.prefs.AppTheme
import com.senex.timetable.presentation.common.prefs.ThemeSharedPrefsHandler
import javax.inject.Inject

class SettingsFragment : BindingFragment<FragmentSettingsBinding>() {

    @Inject
    lateinit var themePrefsHandler: ThemeSharedPrefsHandler

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun FragmentSettingsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())

        val savedTheme = themePrefsHandler.getSavedTheme()
        darkThemeSwitch.isChecked = savedTheme == AppTheme.DARK

        darkThemeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val theme = if (isChecked) AppTheme.DARK else AppTheme.LIGHT
            themePrefsHandler.saveTheme(theme)
        }

        themePrefsHandler.setOnThemeChangeListener {
            AppCompatDelegate.setDefaultNightMode(
                when (it) {
                    AppTheme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
                    AppTheme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
                }
            )
        }
    }
}