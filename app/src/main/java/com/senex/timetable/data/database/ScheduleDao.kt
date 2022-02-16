package com.senex.timetable.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.senex.timetable.data.models.GroupSchedule

interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(schedule: GroupSchedule): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg schedules: GroupSchedule)

    @Query("SELECT * FROM schedules WHERE id = :id")
    suspend fun get(id: Long): LiveData<GroupSchedule>

    @Query("SELECT * FROM schedules WHERE group_id = :groupId")
    suspend fun getByGroupId(groupId: Long): LiveData<GroupSchedule>

    @Query("DELETE FROM schedules")
    suspend fun deleteAll()
}
