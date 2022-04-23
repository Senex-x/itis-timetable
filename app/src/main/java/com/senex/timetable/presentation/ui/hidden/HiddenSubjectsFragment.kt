package com.senex.timetable.presentation.ui.hidden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.senex.timetable.databinding.FragmentHiddenSubjectsBinding
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar

class HiddenSubjectsFragment : Fragment() {
    private var _binding: FragmentHiddenSubjectsBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentHiddenSubjectsBinding::inflate, inflater, container) {
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