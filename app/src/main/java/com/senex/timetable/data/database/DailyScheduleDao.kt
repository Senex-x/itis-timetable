package com.senex.timetable.data.database

import androidx.room.*
import com.senex.timetable.data.models.schedule.DailySchedule

@Dao
interface DailyScheduleDao {
    @Transaction
    @Query("SELECT * FROM daily_schedules WHERE id = :id")
    suspend fun getDaily(id: Long): DailySchedule
}
