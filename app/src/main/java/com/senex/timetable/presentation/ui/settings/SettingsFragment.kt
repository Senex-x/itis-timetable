package com.senex.timetable.presentation.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.BindingFragment

class SettingsFragment : BindingFragment<FragmentSettingsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun FragmentSettingsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())
    }
}