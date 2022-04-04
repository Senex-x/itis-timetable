package com.senex.timetable.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senex.timetable.domain.entities.group.Group
import com.senex.timetable.domain.entities.schedule.DailyScheduleEntity
import com.senex.timetable.domain.entities.schedule.ScheduleEntity
import com.senex.timetable.domain.entities.subject.HiddenSubject
import com.senex.timetable.domain.entities.subject.Subject

@Database(
    entities = [
        ScheduleEntity::class,
        DailyScheduleEntity::class,
        Subject::class,
        HiddenSubject::class,
        Group::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    abstract fun dailyScheduleDao(): DailyScheduleDao

    abstract fun subjectDao(): SubjectDao

    abstract fun groupDao(): GroupDao

    abstract fun hiddenSubjectDao(): HiddenSubjectDao
}

