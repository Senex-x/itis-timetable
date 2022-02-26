package com.senex.timetable.ui.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.senex.timetable.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment() {
    private var _binding: FragmentSubjectBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSubjectBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) = with(binding) {

    }
}