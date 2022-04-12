package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ElectiveSubjectDao: BaseDao<ElectiveSubjectEntity> {
    @Query("SELECT * FROM elective_subjects WHERE id = :id")
    fun get(id: Long): Flow<ElectiveSubjectEntity?>

    @Query("SELECT * FROM elective_subjects")
    fun getAll(): Flow<List<ElectiveSubjectEntity>>

    @Query("DELETE FROM elective_subjects WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM elective_subjects")
    suspend fun deleteAll()
}