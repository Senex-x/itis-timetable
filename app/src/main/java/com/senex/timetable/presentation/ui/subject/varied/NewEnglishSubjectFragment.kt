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

class NewEnglishSubjectFragment : BaseVariedSubjectFragment<FragmentVariedSubjectBinding>() {

    private val args: NewEnglishSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewEnglishSubjectViewModel.Factory
    private val viewModel: NewEnglishSubjectViewModel by assistedViewModel {
        factory.create(args.englishSubjectId)
    }

    override val getBindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

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
        chooseCourseButton.setOnClickListener(navigateToSelectionFragment)
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }
}


