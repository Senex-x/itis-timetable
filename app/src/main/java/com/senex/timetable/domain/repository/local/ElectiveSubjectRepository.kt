package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.subject.ElectiveSubject

interface ElectiveSubjectRepository : BaseRepository<ElectiveSubject, ElectiveSubject, Long> {
    suspend fun setPrimarySubjectId(electiveSubjectId: Long, primarySubjectId: Long?)

    suspend fun show(id: Long)

    suspend fun hide(id: Long)
}
