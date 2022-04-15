package com.senex.timetable.domain.usecase.subject.english.hidden

import com.senex.timetable.domain.repository.local.HiddenEnglishSubjectRepository
import javax.inject.Inject

class DeleteHiddenEnglishSubjectById @Inject constructor(
    private val hiddenEnglishSubjectRepository: HiddenEnglishSubjectRepository
) {
    suspend operator fun invoke(id: Long) =
        hiddenEnglishSubjectRepository.deleteById(id)
}