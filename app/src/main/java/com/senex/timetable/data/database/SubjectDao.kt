package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.SubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao : BaseDao<SubjectEntity, SubjectEntity> {
    @Query("SELECT * FROM subjects WHERE id = :id")
    override fun get(id: Long): Flow<SubjectEntity?>

    @Query("SELECT * FROM subjects")
    override fun getAll(): Flow<List<SubjectEntity>>

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
    fun getAll(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<SubjectEntity>>

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
        AND is_visible == 1
        """
    ) // TODO: Requires testing of isVisible check
    fun getAllVisible(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<SubjectEntity>>

    @Query("DELETE FROM subjects WHERE id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM subjects")
    override suspend fun deleteAll()

    @Query("UPDATE subjects SET is_visible = 1 WHERE id = :id")
    suspend fun show(id: Long)

    @Query("UPDATE subjects SET is_visible = 0 WHERE id = :id")
    suspend fun hide(id: Long)

    @Query("SELECT * FROM subjects WHERE elective_subject_id = :electiveSubjectId")
    fun getAllByElectiveSubjectId(electiveSubjectId: Long): Flow<List<SubjectEntity>>
}
