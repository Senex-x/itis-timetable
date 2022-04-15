package com.senex.timetable.domain.usecase.subject.elective.hidden

import kotlinx.coroutines.flow.first

class IsElectiveSubjectHidden(
    private val getHiddenElectiveSubject: GetHiddenElectiveSubject,
) {
    suspend operator fun invoke(electiveSubjectId: Long) =
        getHiddenElectiveSubject(electiveSubjectId).first() != null
}