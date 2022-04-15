package com.senex.timetable.domain.usecase.subject.english.hidden

import kotlinx.coroutines.flow.first
import javax.inject.Inject

class IsEnglishSubjectHidden @Inject constructor(
    private val getHiddenEnglishSubject: GetHiddenEnglishSubject,
) {
    suspend operator fun invoke(englishSubjectId: Long) =
        getHiddenEnglishSubject(englishSubjectId).first() != null
}