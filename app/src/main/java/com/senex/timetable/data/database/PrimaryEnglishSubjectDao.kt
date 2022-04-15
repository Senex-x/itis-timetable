package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.PrimaryElectiveSubjectEntity
import com.senex.timetable.data.entity.subject.PrimaryEnglishSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrimaryEnglishSubjectDao: BaseDao<PrimaryEnglishSubjectEntity> {
    @Query("SELECT * FROM primary_english_subjects WHERE subject_id = :id")
    fun get(id: Long): Flow<PrimaryEnglishSubjectEntity?>

    @Query(" SELECT * FROM primary_english_subjects WHERE english_subject_id = :englishSubjectId")
    fun getByEnglishSubjectId(englishSubjectId: Long): Flow<PrimaryEnglishSubjectEntity?>

    @Query("SELECT * FROM primary_english_subjects")
    fun getAll(): Flow<List<PrimaryEnglishSubjectEntity>>

    @Query("DELETE FROM primary_english_subjects WHERE subject_id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM primary_english_subjects")
    suspend fun deleteAll()
}