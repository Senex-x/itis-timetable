package com.senex.timetable.presentation.ui.subject.varied.elective

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import com.senex.timetable.presentation.ui.subject.varied.BindingFragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewElectiveSubjectFragment : BindingFragment<FragmentVariedSubjectBinding>() {

    private val args: NewElectiveSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewElectiveSubjectViewModel.Factory
    private val viewModel: NewElectiveSubjectViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

    private val navigateToSelectionFragment: (View) -> Unit = {
        lifecycleScope.launch {
            findNavController().navigate(
                NewElectiveSubjectFragmentDirections.actionNewElectiveSubjectFragmentToNewSelectableElectiveSubjectsFragment(
                    args.electiveSubjectId,
                    viewModel.variedSubject.first().primarySubjectId ?: -1,
                )
            )
        }
    }

    override val onViewCreatedCallback: FragmentVariedSubjectBinding.() -> Unit = {
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isVariedSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.setOnClickListener(navigateToSelectionFragment)
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }
}


