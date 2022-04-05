package com.senex.timetable.domain.repository

interface BaseRepository<in T, out E, K> {
    suspend fun get(id: K): E?

    suspend fun getAll(): List<E>

    suspend fun insert(item: T)

    suspend fun insertAll(vararg items: T)

    suspend fun update(item: T)

    suspend fun delete(item: T)

    suspend fun deleteById(id: K)

    suspend fun deleteAll()
}