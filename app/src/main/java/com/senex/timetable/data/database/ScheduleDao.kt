package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.schedule.ScheduleEntity
import com.senex.timetable.data.entity.schedule.ScheduleInfoEntity

@Dao
interface ScheduleDao : BaseDao<ScheduleInfoEntity> {
    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :id")
    suspend fun get(id: Long): ScheduleEntity?

    @Transaction
    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    suspend fun getByGroupId(groupId: Long): ScheduleEntity?

    @Transaction
    @Query("SELECT * FROM schedules")
    suspend fun getAll(): List<ScheduleEntity>

    @Query("DELETE FROM schedules WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM schedules")
    suspend fun deleteAll()
}
