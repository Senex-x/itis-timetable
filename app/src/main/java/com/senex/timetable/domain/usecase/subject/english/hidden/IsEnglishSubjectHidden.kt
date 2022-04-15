package com.senex.timetable.domain.usecase.subject.english.hidden

import kotlinx.coroutines.flow.first

class IsEnglishSubjectHidden(
    private val getHiddenEnglishSubject: GetHiddenEnglishSubject,
) {
    suspend operator fun invoke(englishSubjectId: Long) =
        getHiddenEnglishSubject(englishSubjectId).first() != null
}