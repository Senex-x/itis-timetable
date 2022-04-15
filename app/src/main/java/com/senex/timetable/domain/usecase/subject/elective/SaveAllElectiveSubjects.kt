package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import javax.inject.Inject

class SaveAllElectiveSubjects @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) {
    suspend operator fun invoke(electiveSubjects: List<ElectiveSubject>) =
        electiveSubjectRepository.insertAll(*electiveSubjects.toTypedArray())
}