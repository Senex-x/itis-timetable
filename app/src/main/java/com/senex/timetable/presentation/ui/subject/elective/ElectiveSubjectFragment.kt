package com.senex.timetable.presentation.ui.subject.elective

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senex.timetable.databinding.FragmentElectiveSubjectBinding
import com.senex.timetable.presentation.common.inflateBinding
import dagger.android.support.DaggerFragment

class ElectiveSubjectFragment : DaggerFragment() {
    private var _binding: FragmentElectiveSubjectBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentElectiveSubjectBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}