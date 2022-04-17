package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.subject.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository : BaseRepository<Subject, Subject, Long> {
    fun getAll(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<Subject>>

    fun getAllVisible(
        groupId: Long,
        dayIndexInWeek: Int,
    ): Flow<List<Subject>>

    suspend fun show(id: Long)

    suspend fun hide(id: Long)

    fun getAllByElectiveSubjectId(
        electiveSubjectId: Long,
    ): Flow<List<Subject>>
}