package com.senex.timetable.data.repositories

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.database.ScheduleDao

class ScheduleRepository(
    database: AppDatabase = MainDatabase(),
): ScheduleDao by database.scheduleDao() {

}