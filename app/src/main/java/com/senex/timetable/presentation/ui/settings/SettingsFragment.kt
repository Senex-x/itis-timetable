package com.senex.timetable.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.Theme
import com.senex.timetable.presentation.common.ThemeSharedPrefsHandler
import javax.inject.Inject

class SettingsFragment : BindingFragment<FragmentSettingsBinding>() {

    @Inject
    lateinit var themePrefs: ThemeSharedPrefsHandler

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun FragmentSettingsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())

        val savedTheme = themePrefs.getSavedTheme()
        darkThemeSwitch.isChecked = savedTheme == Theme.DARK
        darkThemeSwitch.setOnCheckedChangeListener { _, isChecked ->

            val theme = if (isChecked) Theme.DARK else Theme.LIGHT
            themePrefs.saveTheme(theme)
            when(theme) {
                Theme.LIGHT -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Theme.DARK -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }


    }
}