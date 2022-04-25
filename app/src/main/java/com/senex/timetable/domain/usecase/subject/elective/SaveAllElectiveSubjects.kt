package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SaveAllVariedSubjects
import javax.inject.Inject

class SaveAllElectiveSubjects @Inject constructor(
    private val electiveSubjectRepository: ElectiveSubjectRepository,
) : SaveAllVariedSubjects<ElectiveSubject> {
    override suspend fun invoke(variedSubjects: List<ElectiveSubject>) =
        electiveSubjectRepository.insertAll(*variedSubjects.toTypedArray())
}