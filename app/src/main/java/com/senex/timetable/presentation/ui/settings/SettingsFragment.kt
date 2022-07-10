package com.senex.timetable.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.prefs.constants.AppLanguage
import com.senex.timetable.presentation.common.prefs.constants.AppTheme
import com.senex.timetable.presentation.common.prefs.constants.DayNamesDisplayType
import javax.inject.Inject

class SettingsFragment : BindingFragment<FragmentSettingsBinding>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: SettingsViewModel by viewModels { factory }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun FragmentSettingsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())
        toolbarContainer.toolbar.title = resources.getString(R.string.settings_title)

        darkThemeSwitch.isChecked = viewModel.theme.value == AppTheme.DARK
        darkThemeSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setTheme(!isChecked)
        }

        fullDayNamesSwitch.isChecked =
            viewModel.getDayNamesDisplayType() == DayNamesDisplayType.FULL
        fullDayNamesSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDayNamesDisplayType(isChecked)
        }

        languageSwitch.isChecked = viewModel.getLanguage() == AppLanguage.RU
        languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setLanguage(isChecked, requireActivity().baseContext.resources)

            parentFragmentManager.commit { detach(this@SettingsFragment) }
            parentFragmentManager.commit { attach(this@SettingsFragment) }
        }
    }
}
