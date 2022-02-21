package com.senex.timetable.presentation.schedule

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleBinding
import com.senex.timetable.presentation.TimetableApplication
import com.senex.timetable.presentation.groups.GroupsViewModel
import com.senex.timetable.presentation.schedule.recycler.ScheduleRecyclerAdapter
import com.senex.timetable.utils.log
import javax.inject.Inject

class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels(factoryProducer = { factory })

    override fun onAttach(context: Context) {
        (context.applicationContext as TimetableApplication)
            .daggerAppComponent
            .inject(this)

        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentScheduleBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        tableToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_groups_fragment -> {
                    navigateToTableFragment()
                    true
                }
                else -> false
            }
        }

        scheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // TODO: refactor with ListAdapter
        viewModel.schedule.observe(viewLifecycleOwner) {
            log("Schedule live data was updated")
            scheduleRecyclerView.adapter = ScheduleRecyclerAdapter(it)
        }
    }

    private fun navigateToTableFragment() {
        findNavController().navigate(
            R.id.action_tableFragment_to_groupsFragment
        )
    }
}