package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.SetPrimaryVariedSubject
import javax.inject.Inject

class SetPrimaryElectiveSubject @Inject constructor(
    electiveSubjectRepository: ElectiveSubjectRepository,
) : SetPrimaryVariedSubject<ElectiveSubject>(electiveSubjectRepository)