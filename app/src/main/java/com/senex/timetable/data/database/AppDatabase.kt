package com.senex.timetable.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senex.timetable.data.entity.group.GroupEntity
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity
import com.senex.timetable.data.entity.schedule.ScheduleInfoEntity
import com.senex.timetable.data.entity.subject.*

@Database(
    entities = [
        ScheduleInfoEntity::class,
        DailyScheduleInfoEntity::class,
        SubjectEntity::class,
        ElectiveSubjectEntity::class,
        EnglishSubjectEntity::class,
        GroupEntity::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scheduleDao(): ScheduleDao

    abstract fun dailyScheduleDao(): DailyScheduleDao

    abstract fun subjectDao(): SubjectDao

    abstract fun groupDao(): GroupDao

    abstract fun electiveSubjectDao(): ElectiveSubjectDao

    abstract fun englishSubjectDao(): EnglishSubjectDao
}

