package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.HiddenSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HiddenSubjectDao: BaseDao<HiddenSubjectEntity> {
    @Query("SELECT * FROM hidden_subjects WHERE subject_id = :id")
    fun get(id: Long): Flow<HiddenSubjectEntity?>

    @Query("SELECT * FROM hidden_subjects")
    fun getAll(): Flow<List<HiddenSubjectEntity>>

    @Query("DELETE FROM hidden_subjects WHERE subject_id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM hidden_subjects")
    suspend fun deleteAll()
}