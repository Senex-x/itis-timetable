package com.senex.timetable.ui.schedule

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.senex.timetable.ui.schedule.daily.DailyScheduleFragment
import java.time.DayOfWeek

class SchedulePagerAdapter(
    fragment: Fragment,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = DayOfWeek.values().size

    override fun createFragment(position: Int): Fragment =
        DailyScheduleFragment.newInstance(DayOfWeek.of(position + 1))
}
