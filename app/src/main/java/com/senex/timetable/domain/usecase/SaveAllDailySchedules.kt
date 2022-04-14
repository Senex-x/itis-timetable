package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.repository.local.DailyScheduleRepository
import javax.inject.Inject

class SaveAllDailySchedules @Inject constructor(
    private val dailyScheduleRepository: DailyScheduleRepository,
    private val saveAllElectiveSubjects: SaveAllElectiveSubjects,
    private val saveAllEnglishSubjects: SaveAllEnglishSubjects,
    private val saveAllSubjects: SaveAllSubjects,
) {
    suspend operator fun invoke(dailySchedules: List<DailySchedule>) {
        // Do not change the order
        dailyScheduleRepository.insertAll(
            *dailySchedules.map { it.dailyScheduleInfo }.toTypedArray()
        )
        for(dailySchedule in dailySchedules) {
            saveAllElectiveSubjects(dailySchedule.electiveSubjects)
            saveAllEnglishSubjects(dailySchedule.englishSubjects)
            saveAllSubjects(dailySchedule.subjects)
        }
    }
}