package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.repository.local.ScheduleRepository
import com.senex.timetable.domain.usecase.group.SaveGroup
import javax.inject.Inject

class SaveSchedule @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val saveGroup: SaveGroup,
    private val saveAllDailySchedules: SaveAllDailySchedules,
) {
    suspend operator fun invoke(schedule: Schedule) {
        // Do not change the order
        saveGroup(schedule.group)
        scheduleRepository.insert(schedule.scheduleInfo)
        saveAllDailySchedules(schedule.dailySchedules)
    }
}