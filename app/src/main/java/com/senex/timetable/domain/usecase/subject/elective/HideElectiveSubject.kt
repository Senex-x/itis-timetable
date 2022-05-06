package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import javax.inject.Inject

class HideElectiveSubject @Inject constructor(
    electiveSubjectRepository: ElectiveSubjectRepository,
) : HideVariedSubject<ElectiveSubject>(electiveSubjectRepository)