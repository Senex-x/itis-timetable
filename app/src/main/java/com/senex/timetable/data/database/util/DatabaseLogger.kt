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
                val result = database.subjectDao().getAll().first()

                "Database: $result".log()
            }
        }
    }
}