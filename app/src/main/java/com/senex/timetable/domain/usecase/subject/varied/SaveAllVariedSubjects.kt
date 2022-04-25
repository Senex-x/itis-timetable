package com.senex.timetable.domain.usecase.subject.varied

import com.senex.timetable.domain.model.subject.VariedSubject

interface SaveAllVariedSubjects<in T: VariedSubject> {
    suspend operator fun invoke(variedSubjects: List<T>)
}