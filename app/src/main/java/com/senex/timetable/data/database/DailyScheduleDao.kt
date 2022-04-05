package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.schedule.DailyScheduleEntity
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyScheduleDao: BaseDao<DailyScheduleInfoEntity> {
    @Transaction
    @Query("SELECT * FROM daily_schedules WHERE id = :id")
    fun get(id: Long): Flow<DailyScheduleEntity?>

    @Transaction
    @Query("SELECT * FROM daily_schedules")
    fun getAll(): Flow<List<DailyScheduleEntity>>

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
        AND daily_schedules.index_in_week == :dayIndexInWeek
       """
    )
    fun getAllByGroupIdAndDayIndex(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<DailyScheduleEntity>>

    @Query("DELETE FROM daily_schedules WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM daily_schedules")
    suspend fun deleteAll()
}
