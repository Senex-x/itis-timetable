package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.model.subject.VariedSubject
import kotlinx.coroutines.flow.Flow

interface GetVariedSubject {
    operator fun invoke(variedSubjectId: Long): Flow<VariedSubject?>
}