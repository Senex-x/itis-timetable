package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.domain.entities.schedule.Schedule
import com.senex.timetable.domain.entities.schedule.ScheduleInfo

@Dao
interface ScheduleDao : BaseDao<ScheduleInfo> {
    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :id")
    suspend fun get(id: Long): Schedule?

    @Transaction
    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    suspend fun getByGroupId(groupId: Long): Schedule?

    @Transaction
    @Query("SELECT * FROM schedules")
    suspend fun getAll(): List<Schedule>

    @Query("DELETE FROM schedules")
    suspend fun deleteAll()
}
