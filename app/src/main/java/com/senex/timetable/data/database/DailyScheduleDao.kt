package com.senex.timetable.data.database

import androidx.room.*
import com.senex.timetable.data.models.schedule.DailySchedule
import com.senex.timetable.data.models.schedule.DailyScheduleEntity

@Dao
interface DailyScheduleDao: BaseDao<DailyScheduleEntity> {
    @Transaction
    @Query("SELECT * FROM daily_schedules WHERE id = :id")
    suspend fun get(id: Long): DailySchedule

    @Transaction
    @Query("SELECT * FROM daily_schedules")
    suspend fun getAll(): DailySchedule

    @Query("DELETE FROM daily_schedules")
    suspend fun deleteAll()
}