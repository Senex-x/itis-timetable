package com.senex.timetable.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

object MainDatabase {
    private var database: AppDatabase? = null

    operator fun invoke() = database!!

    fun init(context: Context) {
        if (database == null) database =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "database-main"
            ).build()
    }
}

