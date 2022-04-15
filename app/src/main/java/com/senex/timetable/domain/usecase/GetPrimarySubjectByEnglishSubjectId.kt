package com.senex.timetable.domain.usecase

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPrimarySubjectByEnglishSubjectId @Inject constructor(
    private val getPrimaryEnglishSubjectByEnglishSubjectId: GetPrimaryEnglishSubjectByEnglishSubjectId,
    private val getSubjectById: GetSubjectById,
) {
    suspend operator fun invoke(englishSubjectId: Long) =
        getPrimaryEnglishSubjectByEnglishSubjectId(englishSubjectId).map {
            it?.subjectId?.let { subjectId ->
                getSubjectById(subjectId).first()
            }
        }
}