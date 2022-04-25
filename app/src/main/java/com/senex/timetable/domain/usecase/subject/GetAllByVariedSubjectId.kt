package com.senex.timetable.domain.usecase.subject

import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.repository.local.SubjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetAllByVariedSubjectId {
    operator fun invoke(variedSubjectId: Long): Flow<List<Subject>>
}