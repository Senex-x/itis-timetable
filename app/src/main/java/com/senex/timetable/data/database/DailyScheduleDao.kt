package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.model.schedule.DailyScheduleEntity
import com.senex.timetable.data.model.schedule.DailyScheduleInfoEntity

@Dao
interface DailyScheduleDao: BaseDao<DailyScheduleInfoEntity> {
    @Transaction
    @Query("SELECT * FROM daily_schedules WHERE id = :id")
    suspend fun get(id: Long): DailyScheduleEntity?

    @Transaction
    @Query("SELECT * FROM daily_schedules")
    suspend fun getAll(): List<DailyScheduleEntity>

    @Transaction
    @Query("""
        SELECT *
        FROM daily_schedules
        INNER JOIN (
            SELECT schedules.id
            FROM schedules
            WHERE group_id == :groupId
        ) AS scheduleIds 
        ON scheduleIds.id == daily_schedules.schedule_id
        AND daily_schedules.number_in_week == :dayNumberInWeek
       """
    )
    suspend fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<DailyScheduleEntity>

    @Query("DELETE FROM daily_schedules")
    suspend fun deleteAll()
}
