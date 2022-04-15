package com.senex.timetable.data.database.util

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.domain.util.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class DatabaseLogger @Inject constructor(
    private val database: AppDatabase,
) {
    fun log() {
        CoroutineScope(Dispatchers.Default).launch {
            launch {
                val result = database.electiveSubjectDao().getAll().first()

                "Database elective: $result".log()
            }
            launch {
                val result = database.hiddenElectiveSubjectDao().getAll().first()

                "Database hiddenElectiveSubjectDao: $result".log()
            }
            launch {
                val result = database.primaryElectiveSubjectDao().getAll().first()

                "Database primaryElectiveSubjectDao: $result".log()
            }
            launch {
                val result = database.scheduleDao().getAll().first()

                "Database scheduleDao: $result".log()
            }
            launch {
                val result = database.dailyScheduleDao().getAll().first()

                "Database dailyScheduleDao: $result".log()
            }
        }
    }
}