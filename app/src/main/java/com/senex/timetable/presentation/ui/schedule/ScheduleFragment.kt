package com.senex.timetable.presentation.ui.schedule

import android.view.LayoutInflater
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
import com.senex.timetable.presentation.common.BindingFragment
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import javax.inject.Inject

class ScheduleFragment : BindingFragment<FragmentScheduleBinding>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: ScheduleViewModel by viewModels { factory }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScheduleBinding =
        FragmentScheduleBinding::inflate

    override fun FragmentScheduleBinding.onViewCreated() {
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
        pager.adapter = SchedulePagerAdapter(this@ScheduleFragment)
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
}