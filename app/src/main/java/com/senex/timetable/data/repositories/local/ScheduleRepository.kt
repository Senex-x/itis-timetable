package com.senex.timetable.data.repositories.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.data.models.schedule.Schedule
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    database: AppDatabase,
) : ScheduleDao by database.scheduleDao() {

    fun getByGroupIdSorted(groupId: Long) =
        sortSchedule(getByGroupId(groupId))

    private fun sortSchedule(
        source: LiveData<Schedule?>,
    ) = source.map {
        it?.apply {
            it.dailySchedules.sortedWith(
                Comparator.comparingInt { item ->
                    item.dailyScheduleEntity.numberInWeek
                }
            )

            for (dailySchedule in it.dailySchedules) {
                dailySchedule.subjects.sortedWith { subject1, subject2 ->
                    subject1.startTime.compareTo(subject2.startTime)
                }
            }
        }
    }
}