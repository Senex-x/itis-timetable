package com.senex.timetable.presentation.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleContainerBinding

class ScheduleContainerFragment : Fragment() {
    private var _binding: FragmentScheduleContainerBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentScheduleContainerBinding.inflate(
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

        val pagerAdapter = SchedulePagerAdapter(requireActivity())
        binding.pager.adapter = pagerAdapter
    }

    private fun navigateToTableFragment() {
        findNavController().navigate(
            R.id.action_scheduleContainerFragment_to_groupsFragment
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}