package com.senex.timetable.presentation.ui.schedule.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.databinding.FragmentDailyScheduleBinding
import com.senex.timetable.presentation.ui.schedule.ScheduleFragmentDirections
import com.senex.timetable.presentation.ui.schedule.ScheduleViewModel
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectRecyclerAdapter
import dagger.android.support.DaggerFragment
import java.time.DayOfWeek
import javax.inject.Inject

class DailyScheduleFragment : DaggerFragment() {
    private var _binding: FragmentDailyScheduleBinding? = null
    private val binding
        get() = _binding!!

    private val dayOfWeek by lazy {
        arguments?.getSerializable(DAY_OF_WEEK_KEY) as DayOfWeek
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels(
        ownerProducer = { requireParentFragment() },
        factoryProducer = { factory },
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDailyScheduleBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = with(binding) {
        scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val recyclerAdapter = SubjectRecyclerAdapter()
        scheduleRecyclerView.adapter = recyclerAdapter
        recyclerAdapter.onItemClickListener = {
            navigateToSubjectFragment(it)
        }

        viewModel.getDailySubjects(dayOfWeek)
            .observe(viewLifecycleOwner) {
                //log("Got new subject list for day: $dayOfWeek")
                emptyListHint.visibility =
                    if (it.isEmpty()) View.VISIBLE else View.GONE

                recyclerAdapter.submitList(it)
            }
    }

    private fun navigateToSubjectFragment(subjectId: Long) = findNavController().navigate(
        ScheduleFragmentDirections.actionScheduleFragmentToSubjectFragment(
            subjectId
        )
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DAY_OF_WEEK_KEY = "day_of_week"

        fun newInstance(dayOfWeek: DayOfWeek) = DailyScheduleFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DAY_OF_WEEK_KEY, dayOfWeek)
            }
        }
    }
}