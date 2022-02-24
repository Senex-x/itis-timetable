package com.senex.timetable.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleBinding
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels<ScheduleViewModel>(factoryProducer = { factory })

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

        val pagerAdapter = SchedulePagerAdapter(this@ScheduleFragment)
        pager.adapter = pagerAdapter

        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = DayOfWeek.of(position + 1).name
        }.attach()
    }

    private fun navigateToTableFragment() =
        findNavController().navigate(
            R.id.action_scheduleContainerFragment_to_groupsFragment
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}