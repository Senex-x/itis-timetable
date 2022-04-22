package com.senex.timetable.presentation.ui.subject.elective.selectable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.databinding.FragmentSelectableElectiveSubjectsBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.ui.subject.elective.ElectiveSubjectFragmentArgs
import com.senex.timetable.presentation.ui.subject.elective.selectable.recycler.SelectableElectiveSubjectsRecyclerAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SelectableElectiveSubjectsFragment : DaggerFragment() {
    private var _binding: FragmentSelectableElectiveSubjectsBinding? = null
    private val binding
        get() = _binding!!

    private val args: SelectableElectiveSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SelectableSubjectsViewModel.Factory
    private val viewModel: SelectableSubjectsViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentSelectableElectiveSubjectsBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        initRecycler()
    }

    private fun FragmentSelectableElectiveSubjectsBinding.initRecycler(): Unit =
        with(selectableElectiveSubjectsRecycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SelectableElectiveSubjectsRecyclerAdapter().apply {
                /*
                viewModel.electiveSubjects
                    .onEach(::submitList)
                    .launchIn(viewLifecycleOwner.lifecycleScope)
                */
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}