package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.subject.PrimaryElectiveSubject
import kotlinx.coroutines.flow.Flow

interface PrimaryElectiveSubjectRepository :
    BaseRepository<PrimaryElectiveSubject, PrimaryElectiveSubject, Long> {

    fun getByElectiveSubjectId(electiveSubjectId: Long): Flow<PrimaryElectiveSubject?>
}
