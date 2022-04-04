package com.senex.timetable.domain.repository

interface BaseRepository<T> {
    suspend fun insert(item: T)

    suspend fun insertAll(vararg items: T)

    suspend fun update(item: T)

    suspend fun delete(item: T)
}