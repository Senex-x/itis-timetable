package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.schedule.ScheduleEntity
import com.senex.timetable.data.entity.schedule.ScheduleInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao : BaseDao<ScheduleInfoEntity, ScheduleEntity> {
    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :id")
    override fun get(id: Long): Flow<ScheduleEntity?>

    @Transaction
    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    fun getByGroupId(groupId: Long): Flow<ScheduleEntity?>

    @Transaction
    @Query("SELECT * FROM schedules")
    override fun getAll(): Flow<List<ScheduleEntity>>

    @Query("DELETE FROM schedules WHERE id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM schedules")
    override suspend fun deleteAll()

    @Query("SELECT COUNT(1) FROM schedules WHERE group_id = :groupId")
    suspend fun isPresent(groupId: Long): Boolean
}
