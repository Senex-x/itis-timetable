package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ElectiveSubjectDao : BaseDao<ElectiveSubjectEntity, ElectiveSubjectEntity> {
    @Query("SELECT * FROM elective_subjects WHERE id = :id")
    override fun get(id: Long): Flow<ElectiveSubjectEntity?>

    @Query("SELECT * FROM elective_subjects")
    override fun getAll(): Flow<List<ElectiveSubjectEntity>>

    @Query("DELETE FROM elective_subjects WHERE id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM elective_subjects")
    override suspend fun deleteAll()

    @Query("""
        UPDATE elective_subjects 
        SET primary_subject_id = :primarySubjectId 
        WHERE id = :electiveSubjectId"""
    )
    suspend fun setPrimarySubjectId(electiveSubjectId: Long, primarySubjectId: Long?)

    @Query("UPDATE elective_subjects SET is_visible = 1 WHERE id = :id")
    suspend fun show(id: Long)

    @Query("UPDATE elective_subjects SET is_visible = 0 WHERE id = :id")
    suspend fun hide(id: Long)
}