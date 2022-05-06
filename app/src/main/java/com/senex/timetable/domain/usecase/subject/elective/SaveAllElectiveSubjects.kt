package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SaveAllVariedSubjects
import javax.inject.Inject

class SaveAllElectiveSubjects @Inject constructor(
    electiveSubjectRepository: ElectiveSubjectRepository,
) : SaveAllVariedSubjects<ElectiveSubject>(electiveSubjectRepository) {
    suspend operator fun invoke(variedSubjects: List<ElectiveSubject>) =
        insertAll(variedSubjects.toTypedArray())
}