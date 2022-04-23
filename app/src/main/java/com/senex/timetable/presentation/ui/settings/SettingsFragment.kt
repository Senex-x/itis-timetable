package com.senex.timetable.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.senex.timetable.databinding.FragmentSettingsBinding
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentSettingsBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = with(binding) {
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}