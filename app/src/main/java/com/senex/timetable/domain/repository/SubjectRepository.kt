package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.subject.Subject

interface SubjectRepository : BaseRepository<Subject, Subject, Long> {
    suspend fun getAll(
        groupId: Long,
        dayIndexInWeek: Int,
    ): List<Subject>

    suspend fun getAllExcludingHidden(
        groupId: Long,
        dayIndexInWeek: Int,
    ): List<Subject>
}