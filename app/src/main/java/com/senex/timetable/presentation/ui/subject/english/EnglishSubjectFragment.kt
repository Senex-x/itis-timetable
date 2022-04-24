package com.senex.timetable.presentation.ui.subject.english

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentElectiveSubjectBinding
import com.senex.timetable.databinding.FragmentEnglishSubjectBinding
import com.senex.timetable.databinding.SubjectShowHideButtonsBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class EnglishSubjectFragment : DaggerFragment() {
    private var _binding: FragmentEnglishSubjectBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentEnglishSubjectBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        chooseElectiveCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }

    private fun Button.initSelectCourseButton() =
        setOnClickListener(navigateToSelectionFragment)

    private val navigateToSelectionFragment: (view: View) -> Unit = {
        lifecycleScope.launch {
            // TODO
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


