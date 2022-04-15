package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.subject.EnglishSubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EnglishSubjectDao : BaseDao<EnglishSubjectEntity, EnglishSubjectEntity> {
    @Query("SELECT * FROM english_subjects WHERE id = :id")
    override fun get(id: Long): Flow<EnglishSubjectEntity?>

    @Query("SELECT * FROM english_subjects")
    override fun getAll(): Flow<List<EnglishSubjectEntity>>

    @Query("DELETE FROM english_subjects WHERE id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM english_subjects")
    override suspend fun deleteAll()
}