package com.senex.timetable.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.senex.timetable.data.models.schedule.Schedule
import com.senex.timetable.data.models.schedule.ScheduleEntity

@Dao
interface ScheduleDao: BaseDao<ScheduleEntity> {
    @Transaction
    @Query("SELECT * FROM schedules WHERE id = :id")
    fun get(id: Long): LiveData<Schedule>

    @Transaction
    @Query("SELECT * FROM schedules LIMIT 1")
    fun getFirst(): LiveData<Schedule>

    @Transaction
    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    fun getByGroupId(groupId: Long): LiveData<Schedule>
    
    @Transaction
    @Query("SELECT * FROM schedules")
    fun getAll(): LiveData<Schedule>

    @Query("DELETE FROM schedules")
    suspend fun deleteAll()
}
