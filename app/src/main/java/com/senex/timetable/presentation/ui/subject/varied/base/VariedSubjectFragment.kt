package com.senex.timetable.presentation.ui.subject.varied.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.launch

abstract class VariedSubjectFragment<T : VariedSubject> :
    BindingFragment<FragmentVariedSubjectBinding>() {

    protected abstract val viewModel: VariedSubjectViewModel<T>

    protected abstract val selectionFragmentNavDirections: suspend () -> NavDirections

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

    override fun FragmentVariedSubjectBinding.onViewCreated() {
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isVariedSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.setOnClickListener {
            lifecycleScope.launch {
                findNavController().navigate(selectionFragmentNavDirections())
            }
        }
        toolbarContainer.toolbar.setupWithNavController(findNavController())
    }
}