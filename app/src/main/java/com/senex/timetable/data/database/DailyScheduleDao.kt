package com.senex.timetable.data.database

import androidx.lifecycle.LiveData
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
    fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ): LiveData<List<DailySchedule>>

    @Query("DELETE FROM daily_schedules")
    suspend fun deleteAll()
}
