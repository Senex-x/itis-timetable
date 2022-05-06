package com.senex.timetable.domain.repository.local

interface VariedSubjectRepository<T> : BaseRepository<T, T, Long> {
    suspend fun setPrimarySubjectId(variedSubjectId: Long, primarySubjectId: Long?)

    suspend fun show(id: Long)

    suspend fun hide(id: Long)
}