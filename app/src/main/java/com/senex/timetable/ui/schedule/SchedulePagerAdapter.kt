package com.senex.timetable.ui.schedule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.time.DayOfWeek

class SchedulePagerAdapter(
    fa: FragmentActivity,
) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment =
        DailyScheduleFragment(DayOfWeek.of(position + 1))
}
