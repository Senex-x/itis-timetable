package com.senex.timetable.presentation.schedule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SchedulePagerAdapter(
    fa: FragmentActivity,
) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        ScheduleFragment()
}
