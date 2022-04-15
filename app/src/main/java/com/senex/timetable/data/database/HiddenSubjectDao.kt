package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.HiddenSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HiddenSubjectDao: BaseDao<HiddenSubjectEntity, HiddenSubjectEntity> {
    @Query("SELECT * FROM hidden_subjects WHERE subject_id = :id")
    override fun get(id: Long): Flow<HiddenSubjectEntity?>

    @Query("SELECT * FROM hidden_subjects")
    override fun getAll(): Flow<List<HiddenSubjectEntity>>

    @Query("DELETE FROM hidden_subjects WHERE subject_id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM hidden_subjects")
    override suspend fun deleteAll()
}