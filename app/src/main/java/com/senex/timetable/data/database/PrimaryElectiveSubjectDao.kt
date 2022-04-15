package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.PrimaryElectiveSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrimaryElectiveSubjectDao: BaseDao<PrimaryElectiveSubjectEntity> {
    @Query("SELECT * FROM primary_elective_subjects WHERE subject_id = :id")
    fun get(id: Long): Flow<PrimaryElectiveSubjectEntity?>

    @Query(" SELECT * FROM primary_elective_subjects WHERE elective_subject_id = :electiveSubjectId")
    fun getByElectiveSubjectId(electiveSubjectId: Long): Flow<PrimaryElectiveSubjectEntity?>

    @Query("SELECT * FROM primary_elective_subjects")
    fun getAll(): Flow<List<PrimaryElectiveSubjectEntity>>

    @Query("DELETE FROM primary_elective_subjects WHERE subject_id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM primary_elective_subjects")
    suspend fun deleteAll()
}