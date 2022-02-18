package com.senex.timetable.data.database

import androidx.room.*

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(group: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg groups: T)

    @Update
    suspend fun update(group: T)

    @Delete
    suspend fun delete(group: T)
}