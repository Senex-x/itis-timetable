package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    database: AppDatabase,
) : ScheduleRepository, ScheduleDao by database.scheduleDao()