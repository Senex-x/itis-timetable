package com.senex.timetable.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.senex.timetable.data.models.Group
import com.senex.timetable.data.models.GroupSchedule

@Database(entities = [Group::class, GroupSchedule::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao

    abstract fun scheduleDao(): ScheduleDao
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

