package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.PrimaryEnglishSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrimaryEnglishSubjectDao: BaseDao<PrimaryEnglishSubjectEntity, PrimaryEnglishSubjectEntity> {
    @Query("SELECT * FROM primary_english_subjects WHERE subject_id = :id")
    override fun get(id: Long): Flow<PrimaryEnglishSubjectEntity?>

    @Query(" SELECT * FROM primary_english_subjects WHERE english_subject_id = :englishSubjectId")
    fun getByEnglishSubjectId(englishSubjectId: Long): Flow<PrimaryEnglishSubjectEntity?>

    @Query("SELECT * FROM primary_english_subjects")
    override fun getAll(): Flow<List<PrimaryEnglishSubjectEntity>>

    @Query("DELETE FROM primary_english_subjects WHERE subject_id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM primary_english_subjects")
    override suspend fun deleteAll()
}