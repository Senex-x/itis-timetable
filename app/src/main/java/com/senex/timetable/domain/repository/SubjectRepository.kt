package com.senex.timetable.domain.repository

import com.senex.timetable.domain.entities.subject.Subject

interface SubjectRepository : BaseRepository<Subject> {
    suspend fun get(id: Long): Subject?

    suspend fun getAll(): List<Subject>

    suspend fun getAll(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<Subject>

    suspend fun getAllExcludingHidden(
        groupId: Long,
        dayNumberInWeek: Int,
    ): List<Subject>

    suspend fun delete(id: Long)

    suspend fun deleteAll()
}