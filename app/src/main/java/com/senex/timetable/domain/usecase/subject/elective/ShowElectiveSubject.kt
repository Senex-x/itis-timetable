package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import javax.inject.Inject

class ShowElectiveSubject @Inject constructor(
    electiveSubjectRepository: ElectiveSubjectRepository,
) : ShowVariedSubject<ElectiveSubject>(electiveSubjectRepository)