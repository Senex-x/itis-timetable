package com.senex.timetable.presentation.ui.subject.varied.elective.selectable

import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.SetPrimaryElectiveSubject
import com.senex.timetable.presentation.ui.subject.varied.SelectableVariedSubjectsViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewSelectableElectiveSubjectsViewModel @AssistedInject constructor(
    @Assisted electiveSubjectId: Long,
    @Assisted savedPrimarySubjectId: Long?,
    setPrimaryElectiveSubject: SetPrimaryElectiveSubject,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId,
) : SelectableVariedSubjectsViewModel<ElectiveSubject>(
    electiveSubjectId,
    savedPrimarySubjectId,
    setPrimaryElectiveSubject,
    getElectiveSubject,
    getAllByElectiveSubjectId,
) {
    @AssistedFactory
    interface Factory {
        fun create(
            electiveSubjectId: Long,
            primarySubjectId: Long?,
        ): NewSelectableElectiveSubjectsViewModel
    }
}