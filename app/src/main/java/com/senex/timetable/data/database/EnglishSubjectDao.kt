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

    @Query("""
        UPDATE english_subjects 
        SET primary_subject_id = :primarySubjectId 
        WHERE id = :englishSubjectId"""
    )
    suspend fun setPrimarySubjectId(englishSubjectId: Long, primarySubjectId: Long?)

    @Query("UPDATE english_subjects SET is_visible = 1 WHERE id = :id")
    suspend fun show(id: Long)

    @Query("UPDATE english_subjects SET is_visible = 0 WHERE id = :id")
    suspend fun hide(id: Long)
}