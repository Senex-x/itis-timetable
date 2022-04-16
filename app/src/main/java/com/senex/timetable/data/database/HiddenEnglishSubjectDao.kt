package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.HiddenEnglishSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HiddenEnglishSubjectDao : BaseDao<HiddenEnglishSubjectEntity, HiddenEnglishSubjectEntity> {
    @Query("SELECT * FROM hidden_english_subjects WHERE english_subject_id = :id")
    override fun get(id: Long): Flow<HiddenEnglishSubjectEntity?>

    @Query("SELECT * FROM hidden_english_subjects")
    override fun getAll(): Flow<List<HiddenEnglishSubjectEntity>>

    @Query("DELETE FROM hidden_english_subjects WHERE english_subject_id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM hidden_english_subjects")
    override suspend fun deleteAll()
}