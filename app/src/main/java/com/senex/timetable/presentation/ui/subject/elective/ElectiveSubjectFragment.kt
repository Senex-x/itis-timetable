package com.senex.timetable.presentation.ui.subject.elective

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentElectiveSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import dagger.android.support.DaggerFragment
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
        initSelectCourseButton()
    }

    private fun FragmentElectiveSubjectBinding.initSelectCourseButton() =
        chooseElectiveCourseButton.setOnClickListener(navigateToSelectionFragment)

    private val navigateToSelectionFragment: (view: View) -> Unit = {
        findNavController().navigate(
            ElectiveSubjectFragmentDirections.actionElectiveSubjectFragmentToSelectableElectiveSubjectsFragment(
                args.electiveSubjectId
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}