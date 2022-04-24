package com.senex.timetable.presentation.ui.subject.english

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentEnglishSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import com.senex.timetable.presentation.ui.subject.elective.ElectiveSubjectFragmentDirections
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class EnglishSubjectFragment : DaggerFragment() {
    private var _binding: FragmentEnglishSubjectBinding? = null
    private val binding
        get() = _binding!!

    private val args: EnglishSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: EnglishSubjectViewModel.Factory
    private val viewModel: EnglishSubjectViewModel by assistedViewModel {
        factory.create(args.englishSubjectId)
    }

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
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isEnglishSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }

    private fun Button.initSelectCourseButton() =
        setOnClickListener(navigateToSelectionFragment)

    private val navigateToSelectionFragment: (View) -> Unit = {
        lifecycleScope.launch {
            findNavController().navigate(
                EnglishSubjectFragmentDirections.actionEnglishSubjectFragmentToSelectableEnglishSubjectsFragment(
                    args.englishSubjectId,
                    viewModel.englishSubject.first().primarySubjectId ?: -1,
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


