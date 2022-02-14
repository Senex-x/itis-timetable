package com.senex.timetable.presentation.fragments.schedule

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.repositories.MainRepository

class ScheduleViewModel: ViewModel() {
    val schedule = MainRepository.getScheduleListItems()
}