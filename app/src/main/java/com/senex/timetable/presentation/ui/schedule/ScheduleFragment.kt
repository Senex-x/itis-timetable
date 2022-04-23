package com.senex.timetable.presentation.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentScheduleBinding
import com.senex.timetable.presentation.common.inflateBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleFragment : DaggerFragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding
        get() = _binding!!

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels { factory }

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
        navDrawer.setupWithNavController(findNavController())

        viewLifecycleOwner.lifecycleScope.launch {
            tableToolbar.title = viewModel.getGroup()?.name
                ?: "Schedules"
        }

        tableToolbar.setupWithNavController(
            findNavController(),
            AppBarConfiguration(
                findNavController().graph,
                drawerLayout
            )
        )

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