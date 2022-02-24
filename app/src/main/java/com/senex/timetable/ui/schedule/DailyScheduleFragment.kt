package com.senex.timetable.ui.schedule

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.daggerAppComponent
import com.senex.timetable.databinding.FragmentDailyScheduleBinding
import com.senex.timetable.ui.schedule.recycler.ScheduleRecyclerAdapter
import java.time.DayOfWeek
import javax.inject.Inject

class DailyScheduleFragment(
    private val dayOfWeek: DayOfWeek,
) : Fragment() {
    private var _binding: FragmentDailyScheduleBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels(
        { requireParentFragment() },
        { factory },
    )

    override fun onAttach(context: Context) {
        context.daggerAppComponent.inject(this)

        super.onAttach(context)
    }

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
    ): Unit = with(binding) {
        scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // TODO: refactor with ListAdapter
        viewModel.getDailySubjects(dayOfWeek).observe(viewLifecycleOwner) {
            scheduleRecyclerView.adapter = ScheduleRecyclerAdapter(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}