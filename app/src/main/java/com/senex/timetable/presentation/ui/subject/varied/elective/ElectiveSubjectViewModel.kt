package com.senex.timetable.presentation.ui.subject.varied.elective

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.HideElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.ShowElectiveSubject
import com.senex.timetable.presentation.ui.subject.varied.base.VariedSubjectViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ElectiveSubjectViewModel @AssistedInject constructor(
    @Assisted electiveSubjectId: Long,
    showElectiveSubject: ShowElectiveSubject,
    hideElectiveSubject: HideElectiveSubject,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId,
) : VariedSubjectViewModel<ElectiveSubject>(
    electiveSubjectId,
    showElectiveSubject,
    hideElectiveSubject,
    getElectiveSubject,
    getAllByElectiveSubjectId,
) {
    @AssistedFactory
    interface Factory {
        fun create(electiveSubjectId: Long): ElectiveSubjectViewModel
    }
}