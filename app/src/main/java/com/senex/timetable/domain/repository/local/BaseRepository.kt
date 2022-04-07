package com.senex.timetable.domain.repository.local

import kotlinx.coroutines.flow.Flow

interface BaseRepository<in T, out E, K> {
    fun get(id: K): Flow<E?>

    fun getAll(): Flow<List<E>>

    suspend fun insert(item: T)

    suspend fun insertAll(vararg items: T)

    suspend fun update(item: T)

    suspend fun delete(item: T)

    suspend fun deleteById(id: K)

    suspend fun deleteAll()
}