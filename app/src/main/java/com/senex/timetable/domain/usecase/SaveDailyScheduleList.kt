package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.repository.local.DailyScheduleRepository
import javax.inject.Inject

class SaveDailyScheduleList @Inject constructor(
    private val dailyScheduleRepository: DailyScheduleRepository,
    private val saveSubjectList: SaveSubjectList,
) {
    suspend operator fun invoke(dailySchedules: List<DailySchedule>) {
        // Do not change the order
        dailyScheduleRepository.insertAll(
            *dailySchedules.map { it.dailyScheduleInfo }.toTypedArray()
        )
        for(dailySchedule in dailySchedules) {
            saveSubjectList(dailySchedule.subjects)
        }
    }
}