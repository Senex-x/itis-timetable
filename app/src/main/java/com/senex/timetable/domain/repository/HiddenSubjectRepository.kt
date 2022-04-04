package com.senex.timetable.domain.repository

import com.senex.timetable.domain.model.subject.HiddenSubject

interface HiddenSubjectRepository : BaseRepository<HiddenSubject> {
    suspend fun get(id: Long): HiddenSubject?

    suspend fun getAll(): List<HiddenSubject>

    suspend fun delete(id: Long)

    suspend fun deleteAll()
}

