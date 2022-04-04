package com.senex.timetable.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senex.timetable.data.model.group.GroupEntity
import com.senex.timetable.data.model.schedule.DailyScheduleInfoEntity
import com.senex.timetable.data.model.schedule.ScheduleInfoEntity
import com.senex.timetable.data.model.subject.HiddenSubjectEntity
import com.senex.timetable.data.model.subject.SubjectEntity

@Database(
    entities = [
        ScheduleInfoEntity::class,
        DailyScheduleInfoEntity::class,
        SubjectEntity::class,
        HiddenSubjectEntity::class,
        GroupEntity::class,
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

