package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.schedule.ScheduleEntity
import com.senex.timetable.data.entity.schedule.ScheduleInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao : BaseDao<ScheduleInfoEntity> {
    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :id")
    fun get(id: Long): Flow<ScheduleEntity?>

    @Transaction
    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    fun getByGroupId(groupId: Long): Flow<ScheduleEntity?>

    @Transaction
    @Query("SELECT * FROM schedules")
    fun getAll(): Flow<List<ScheduleEntity>>

    @Query("DELETE FROM schedules WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM schedules")
    suspend fun deleteAll()
}
