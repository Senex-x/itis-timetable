package com.senex.timetable.presentation.ui.subject.varied

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class VariedSubjectFragment : DaggerFragment() {
    private var _binding: FragmentVariedSubjectBinding? = null
    private val binding
        get() = _binding!!

    private val args: VariedSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: VariedSubjectViewModel.Factory
    private val viewModel: VariedSubjectViewModel by assistedViewModel {
        factory.create(args.variedSubjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentVariedSubjectBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isVariedSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


