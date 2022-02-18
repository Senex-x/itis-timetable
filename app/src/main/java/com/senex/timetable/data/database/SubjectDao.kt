package com.senex.timetable.data.database

import androidx.room.*
import com.senex.timetable.data.models.schedule.Subject

@Dao
interface SubjectDao: BaseDao<Subject> {
    @Query("SELECT * FROM subjects WHERE id = :id")
    suspend fun get(id: Long): Subject?

    @Query("SELECT * FROM subjects")
    suspend fun getAll(): List<Subject>

    @Query("DELETE FROM subjects WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM subjects")
    suspend fun deleteAll()
}
