package com.senex.timetable.data.database.util

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.domain.util.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DatabaseLogger @Inject constructor(
    private val database: AppDatabase,
) {
    private lateinit var job: Job

    fun start() {
        job = CoroutineScope(Dispatchers.Default).launch {
            1L.let {
                launch {
                    database.scheduleDao().getAll().collect {
                        "Database ScheduleInfo: $it".log()
                    }
                }
                launch {
                    database.dailyScheduleDao().getAll().collect {
                        "Database DailyScheduleInfo: $it".log()
                    }
                }
                launch {
                    database.subjectDao().getAll().collect {
                        "Database Subject: $it".log()
                    }
                }
                launch {
                    database.groupDao().getAll().collect {
                        "Database Group: $it".log()
                    }
                }
            }
        }
    }

    fun stop() {
        job.cancel()
    }
}