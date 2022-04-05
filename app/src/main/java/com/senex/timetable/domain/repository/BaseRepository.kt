package com.senex.timetable.domain.repository

interface BaseRepository<T, K> {
    suspend fun insert(item: T)

    suspend fun insertAll(vararg items: T)

    suspend fun get(id: K): T?

    suspend fun getAll(): List<T>

    suspend fun update(item: T)

    suspend fun delete(item: T)

    suspend fun deleteById(id: K)

    suspend fun deleteAll()
}