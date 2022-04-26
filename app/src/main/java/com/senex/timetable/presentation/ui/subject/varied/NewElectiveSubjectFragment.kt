package com.senex.timetable.presentation.ui.subject.varied

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewElectiveSubjectFragment : BaseVariedSubjectFragment<FragmentVariedSubjectBinding>() {

    private val args: VariedSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewElectiveSubjectViewModel.Factory
    private val viewModel: NewElectiveSubjectViewModel by assistedViewModel {
        factory.create(args.variedSubjectId)
    }

    override val getBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

    private fun Button.initSelectCourseButton() =
        setOnClickListener(navigateToSelectionFragment)

    private val navigateToSelectionFragment: (View) -> Unit = {
        lifecycleScope.launch {/*
            findNavController().navigate(
                VariedSubjectFragmentDirections.actionVariedSubjectFragmentToSelectableVariedSubjectsFragment(
                    args.variedSubjectId,
                    viewModel.variedSubject.first().primarySubjectId ?: -1,
                )
            )*/
        }
    }

    override val onViewCreatedCallback: FragmentVariedSubjectBinding.() -> Unit = {
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isVariedSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }
}


