package com.senex.timetable.viewmodels

import androidx.lifecycle.ViewModel
import com.senex.timetable.model.repositories.MainRepository

class ScheduleViewModel: ViewModel() {
    val schedule = MainRepository.getScheduleListItems()
}