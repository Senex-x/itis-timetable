package com.senex.timetable.presentation.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleBinding
import com.senex.timetable.presentation.common.inflateBinding
import java.time.DayOfWeek

class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentScheduleBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = with(binding) {
        initToolbar()
        initViewPager()
        initTabBar()
    }

    private fun FragmentScheduleBinding.initToolbar() {
        tableToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_groups_fragment -> {
                    navigateToGroupsFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun FragmentScheduleBinding.initViewPager() {
        val pagerAdapter = SchedulePagerAdapter(this@ScheduleFragment)
        pager.adapter = pagerAdapter
    }

    private fun FragmentScheduleBinding.initTabBar() {
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = DayOfWeek.of(position + 1).name
        }.attach()
    }

    private fun navigateToGroupsFragment() = findNavController().navigate(
        ScheduleFragmentDirections.actionScheduleFragmentToGroupsFragment()
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}