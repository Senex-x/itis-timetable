package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.HiddenElectiveSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HiddenElectiveSubjectDao : BaseDao<HiddenElectiveSubjectEntity, HiddenElectiveSubjectEntity> {
    @Query("SELECT * FROM hidden_elective_subjects WHERE elective_subject_id = :id")
    override fun get(id: Long): Flow<HiddenElectiveSubjectEntity?>

    @Query("SELECT * FROM hidden_elective_subjects")
    override fun getAll(): Flow<List<HiddenElectiveSubjectEntity>>

    @Query("DELETE FROM hidden_elective_subjects WHERE elective_subject_id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM hidden_elective_subjects")
    override suspend fun deleteAll()
}