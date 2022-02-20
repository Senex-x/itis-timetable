package com.senex.timetable.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.data.models.schedule.Schedule

class ScheduleRepository(
    database: AppDatabase = MainDatabase(),
) : ScheduleDao by database.scheduleDao() {

    fun getByGroupIdSorted(groupId: Long) =
        sortSchedule(getByGroupId(groupId))

    private fun sortSchedule(
        source: LiveData<Schedule>,
    ) = Transformations.map(source) {
        it.dailySchedules.sortedWith(
            Comparator.comparingInt { item ->
                item.dailySchedule.numberInWeek
            }
        )

        for (dailySchedule in it.dailySchedules) {
            dailySchedule.subjects.sortedWith { subject1, subject2 ->
                subject1.startTime.compareTo(subject2.startTime)
            }
        }

        it
    }
}