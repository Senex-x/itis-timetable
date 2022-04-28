package com.senex.timetable.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.prefs.AppTheme
import javax.inject.Inject

class SettingsFragment : BindingFragment<FragmentSettingsBinding>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: SettingsViewModel by viewModels { factory }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun FragmentSettingsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())

        darkThemeSwitch.isChecked = viewModel.theme.value == AppTheme.DARK
        darkThemeSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setTheme(!isChecked)
        }
    }
}