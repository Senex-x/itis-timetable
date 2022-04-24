package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.subject.EnglishSubject

interface EnglishSubjectRepository : BaseRepository<EnglishSubject, EnglishSubject, Long> {
    suspend fun setPrimarySubjectId(englishSubjectId: Long, primarySubjectId: Long?)

    suspend fun show(id: Long)

    suspend fun hide(id: Long)
}
