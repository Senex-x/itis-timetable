package com.senex.timetable.domain.usecase

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPrimarySubjectByElectiveSubjectId @Inject constructor(
    private val getPrimaryElectiveSubjectByElectiveSubjectId: GetPrimaryElectiveSubjectByElectiveSubjectId,
    private val getSubjectById: GetSubjectById,
) {
    suspend operator fun invoke(electiveSubjectId: Long) =
        getPrimaryElectiveSubjectByElectiveSubjectId(electiveSubjectId).map {
            it?.subjectId?.let { subjectId ->
                getSubjectById(subjectId).first()
            }
        }
}