package com.senex.timetable.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.data.models.schedule.DailyScheduleEntity
import com.senex.timetable.data.models.schedule.ScheduleEntity
import com.senex.timetable.data.models.schedule.Subject

@Database(
    entities = [
        ScheduleEntity::class,
        DailyScheduleEntity::class,
        Subject::class,
        Group::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    abstract fun dailyScheduleDao(): DailyScheduleDao

    abstract fun subjectDao(): SubjectDao

    abstract fun groupDao(): GroupDao
}

