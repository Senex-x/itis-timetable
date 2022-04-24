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
import com.senex.timetable.databinding.SubjectShowHideButtonsBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar
import dagger.android.support.DaggerFragment
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
        subjectShowHideButtons.initShowHideCourseButtons()
        chooseEnglishCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initNavToolbar(findNavController())
    }

    private fun SubjectShowHideButtonsBinding.initShowHideCourseButtons() {
        lifecycleScope.launch {
            viewModel.isEnglishSubjectVisible.collect {
                if (it) {
                    showSubjectButton.visibility = View.INVISIBLE
                    hideSubjectButton.visibility = View.VISIBLE
                } else {
                    showSubjectButton.visibility = View.VISIBLE
                    hideSubjectButton.visibility = View.INVISIBLE
                }
            }
        }
        hideSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = false)
        }
        showSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = true)
        }
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


