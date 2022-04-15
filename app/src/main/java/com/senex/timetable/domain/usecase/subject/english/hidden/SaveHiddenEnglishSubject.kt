package com.senex.timetable.domain.usecase.subject.english.hidden

import com.senex.timetable.domain.model.subject.HiddenEnglishSubject
import com.senex.timetable.domain.repository.local.HiddenEnglishSubjectRepository
import javax.inject.Inject

class SaveHiddenEnglishSubject @Inject constructor(
    private val hiddenEnglishSubjectRepository: HiddenEnglishSubjectRepository,
) {
    suspend operator fun invoke(item: HiddenEnglishSubject) =
        hiddenEnglishSubjectRepository.insert(item)
}