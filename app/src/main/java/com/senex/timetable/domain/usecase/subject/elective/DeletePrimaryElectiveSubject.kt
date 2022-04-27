package com.senex.timetable.domain.usecase.subject.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.usecase.subject.varied.DeletePrimaryVariedSubject
import javax.inject.Inject

class DeletePrimaryElectiveSubject @Inject constructor(
    setPrimaryElectiveSubject: SetPrimaryElectiveSubject,
) : DeletePrimaryVariedSubject<ElectiveSubject>(setPrimaryElectiveSubject)