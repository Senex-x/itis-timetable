package com.senex.timetable.presentation.ui.hidden

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentHiddenSubjectsBinding
import com.senex.timetable.presentation.common.BindingFragment

class HiddenSubjectsFragment : BindingFragment<FragmentHiddenSubjectsBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHiddenSubjectsBinding =
        FragmentHiddenSubjectsBinding::inflate

    override fun FragmentHiddenSubjectsBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())
        toolbarContainer.toolbar.title = resources.getString(R.string.hidden_subjects_title)
    }
}