package com.senex.timetable.presentation.ui.subject.elective

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.HideElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.ShowElectiveSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ElectiveSubjectViewModel @AssistedInject constructor(
    @Assisted private val electiveSubjectId: Long,
    private val showElectiveSubject: ShowElectiveSubject,
    private val hideElectiveSubject: HideElectiveSubject,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId,
) : ViewModel() {
    val electiveSubject = getElectiveSubject(electiveSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val electiveSubjects = getAllByElectiveSubjectId(electiveSubjectId)

    val isElectiveSubjectVisible = electiveSubject.map {
        it.isVisible
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        CoroutineScope(Dispatchers.Default).launch {
            if (isVisible)
                showElectiveSubject(electiveSubjectId)
            else
                hideElectiveSubject(electiveSubjectId)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(electiveSubjectId: Long): ElectiveSubjectViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given electiveSubjectId: $electiveSubjectId is invalid"
}