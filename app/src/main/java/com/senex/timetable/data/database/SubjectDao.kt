package com.senex.timetable.data.database

import androidx.room.*
import com.senex.timetable.data.models.schedule.Subject

@Dao
interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Subject): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Subject)

    @Query("SELECT * FROM subjects WHERE id = :id")
    suspend fun get(id: Long): Subject?

    @Query("SELECT * FROM subjects")
    suspend fun getAll(): List<Subject>

    @Delete
    suspend fun delete(item: Subject)

    @Query("DELETE FROM subjects WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM subjects")
    suspend fun deleteAll()
}
