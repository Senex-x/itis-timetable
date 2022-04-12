package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.EnglishSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EnglishSubjectDao : BaseDao<EnglishSubjectEntity> {
    @Query("SELECT * FROM english_subjects WHERE id = :id")
    fun get(id: Long): Flow<EnglishSubjectEntity?>

    @Query("SELECT * FROM english_subjects")
    fun getAll(): Flow<List<EnglishSubjectEntity>>

    @Query("DELETE FROM english_subjects WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM english_subjects")
    suspend fun deleteAll()
}