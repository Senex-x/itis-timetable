package com.senex.timetable.presentation.ui.subject.elective

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.map

class ElectiveSubjectViewModel @AssistedInject constructor(
    @Assisted private val electiveSubjectId: Long,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId
) : ViewModel() {
    val electiveSubject = getElectiveSubject(electiveSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val electiveSubjects = getAllByElectiveSubjectId(electiveSubjectId)

    @AssistedFactory
    interface Factory {
        fun create(electiveSubjectId: Long): ElectiveSubjectViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given electiveSubjectId: $electiveSubjectId. is invalid"
}