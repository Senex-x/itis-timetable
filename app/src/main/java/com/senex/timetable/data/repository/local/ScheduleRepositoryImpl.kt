package com.senex.timetable.data.repository.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.data.model.schedule.Schedule
import com.senex.timetable.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    database: AppDatabase,
) : ScheduleRepository, ScheduleDao by database.scheduleDao() {

    fun getByGroupIdSorted(groupId: Long) =
        sortSchedule(getByGroupId(groupId))

    private fun sortSchedule(
        source: LiveData<Schedule?>,
    ) = source.map {
        it?.apply {
            dailySchedules.sortedWith(
                Comparator.comparingInt { item ->
                    item.dailyScheduleEntity.numberInWeek
                }
            )

            for (dailySchedule in dailySchedules) {
                dailySchedule.subjects.sortedWith { subject1, subject2 ->
                    subject1.startTime.compareTo(subject2.startTime)
                }
            }
        }
    }
}