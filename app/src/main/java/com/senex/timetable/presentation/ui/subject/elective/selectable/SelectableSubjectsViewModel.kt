package com.senex.timetable.presentation.ui.subject.elective.selectable

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.map

class SelectableSubjectsViewModel @AssistedInject constructor(
    @Assisted private val selectableSubjectId: Long,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId
) : ViewModel() {
    val electiveSubject = getElectiveSubject(selectableSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val electiveSubjects = getAllByElectiveSubjectId(selectableSubjectId)

    @AssistedFactory
    interface Factory {
        fun create(electiveSubjectId: Long): SelectableSubjectsViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given electiveSubjectId: $selectableSubjectId is invalid"
}