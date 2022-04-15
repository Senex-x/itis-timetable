package com.senex.timetable.domain.usecase.subject.elective.hidden

import kotlinx.coroutines.flow.first
import javax.inject.Inject

class IsElectiveSubjectHidden @Inject constructor(
    private val getHiddenElectiveSubject: GetHiddenElectiveSubject,
) {
    suspend operator fun invoke(electiveSubjectId: Long) =
        getHiddenElectiveSubject(electiveSubjectId).first() != null
}