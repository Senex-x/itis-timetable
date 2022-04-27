package com.senex.timetable.presentation.ui.subject.varied

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.launch

abstract class VariedSubjectFragment<T : VariedSubject> :
    BindingFragment<FragmentVariedSubjectBinding>() {

    protected abstract val viewModel: BaseVariedSubjectViewModel<T>

    protected abstract val selectionFragmentNavDirections: suspend () -> NavDirections

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

    override val onViewCreatedCallback: FragmentVariedSubjectBinding.() -> Unit = {
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
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }
}


