package com.senex.timetable.presentation.ui.subject.elective

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.senex.timetable.databinding.FragmentElectiveSubjectBinding
import com.senex.timetable.databinding.SubjectShowHideButtonsBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class ElectiveSubjectFragment : DaggerFragment() {
    private var _binding: FragmentElectiveSubjectBinding? = null
    private val binding
        get() = _binding!!

    private val args: ElectiveSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: ElectiveSubjectViewModel.Factory
    private val viewModel: ElectiveSubjectViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentElectiveSubjectBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        subjectShowHideButtons.initShowHideCourseButtons()
        chooseElectiveCourseButton.initSelectCourseButton()
        toolbarContainer.toolbar.initToolbar()
    }

    private fun MaterialToolbar.initToolbar() {
        setupWithNavController(
            findNavController(),
            AppBarConfiguration(findNavController().graph)
        )
    }

    private fun SubjectShowHideButtonsBinding.initShowHideCourseButtons() {
        lifecycleScope.launch {
            viewModel.isElectiveSubjectVisible.collect {
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
            findNavController().navigate(
                ElectiveSubjectFragmentDirections.actionElectiveSubjectFragmentToSelectableElectiveSubjectsFragment(
                    args.electiveSubjectId,
                    viewModel.electiveSubject.first().primarySubjectId ?: -1,
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


