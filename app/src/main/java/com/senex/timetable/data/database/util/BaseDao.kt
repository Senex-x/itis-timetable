package com.senex.timetable.data.database.util

import androidx.room.*

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg item: T)

    @Update
    suspend fun update(item: T)

    @Delete
    suspend fun delete(item: T)
}