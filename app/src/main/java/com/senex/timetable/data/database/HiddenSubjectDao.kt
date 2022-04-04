package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.model.subject.HiddenSubject

@Dao
interface HiddenSubjectDao: BaseDao<HiddenSubject> {
    @Query("SELECT * FROM hidden_subjects WHERE subject_id = :id")
    suspend fun get(id: Long): HiddenSubject?

    @Query("SELECT * FROM hidden_subjects")
    suspend fun getAll(): List<HiddenSubject>

    @Query("DELETE FROM hidden_subjects WHERE subject_id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM hidden_subjects")
    suspend fun deleteAll()
}