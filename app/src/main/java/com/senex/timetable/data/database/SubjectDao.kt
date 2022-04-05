package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.SubjectEntity

@Dao
interface SubjectDao : BaseDao<SubjectEntity> {
    @Query("SELECT * FROM subjects WHERE id = :id")
    suspend fun get(id: Long): SubjectEntity?

    @Query("SELECT * FROM subjects")
    suspend fun getAll(): List<SubjectEntity>

    @Query("""
        SELECT *
        FROM subjects
        INNER JOIN (
            SELECT daily_schedules.id 
            FROM daily_schedules
            INNER JOIN (
                SELECT schedules.id
                FROM schedules
                WHERE group_id == :groupId
            ) AS scheduleIds 
            ON scheduleIds.id == daily_schedules.schedule_id
            AND daily_schedules.index_in_week == :dayIndexInWeek
        ) AS dailyScheduleIds
        ON dailyScheduleIds.id == subjects.daily_schedule_id
        """
    )
    suspend fun getAll(
        groupId: Long,
        dayIndexInWeek: Int,
    ): List<SubjectEntity>

    @Query("""
        SELECT *
        FROM subjects
        INNER JOIN (
            SELECT daily_schedules.id 
            FROM daily_schedules
            INNER JOIN (
                SELECT schedules.id
                FROM schedules
                WHERE group_id == :groupId
            ) AS scheduleIds 
            ON scheduleIds.id == daily_schedules.schedule_id
            AND daily_schedules.index_in_week == :dayIndexInWeek
        ) AS dailyScheduleIds
        ON dailyScheduleIds.id == subjects.daily_schedule_id
        AND subjects.id NOT IN hidden_subjects
        """
    )
    suspend fun getAllExcludingHidden(
        groupId: Long,
        dayIndexInWeek: Int,
    ): List<SubjectEntity>

    @Query("DELETE FROM subjects WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM subjects")
    suspend fun deleteAll()
}
