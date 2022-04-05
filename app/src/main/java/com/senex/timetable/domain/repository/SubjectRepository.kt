package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.subject.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository : BaseRepository<Subject, Subject, Long> {
    fun getAll(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<Subject>>

    fun getAllExcludingHidden(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<Subject>>
}