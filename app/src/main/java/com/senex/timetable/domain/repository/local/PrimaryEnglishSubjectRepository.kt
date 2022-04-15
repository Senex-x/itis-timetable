package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.subject.PrimaryEnglishSubject
import kotlinx.coroutines.flow.Flow

interface PrimaryEnglishSubjectRepository :
    BaseRepository<PrimaryEnglishSubject, PrimaryEnglishSubject, Long> {

    fun getByEnglishSubjectId(englishSubjectId: Long): Flow<PrimaryEnglishSubject?>
}
