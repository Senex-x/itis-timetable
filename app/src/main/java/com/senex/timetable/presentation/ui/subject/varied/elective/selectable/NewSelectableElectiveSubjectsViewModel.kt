package com.senex.timetable.presentation.ui.subject.varied.elective.selectable

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByElectiveSubjectId
import com.senex.timetable.domain.usecase.subject.elective.GetElectiveSubject
import com.senex.timetable.domain.usecase.subject.elective.SetPrimaryElectiveSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class NewSelectableElectiveSubjectsViewModel @AssistedInject constructor(
    @Assisted private val selectableSubjectId: Long,
    @Assisted private val savedPrimarySubjectId: Long?,
    private val setPrimaryElectiveSubject: SetPrimaryElectiveSubject,
    getElectiveSubject: GetElectiveSubject,
    getAllByElectiveSubjectId: GetAllByElectiveSubjectId,
) : ViewModel() {
    private val electiveSubjectId = getElectiveSubject(selectableSubjectId).map {
        it?.id ?: throw IllegalArgumentException(invalidIdMessage)
    }

    val electiveSubjects = getAllByElectiveSubjectId(selectableSubjectId)

    private val _mutableStateFlow = MutableStateFlow(savedPrimarySubjectId)
    val primarySubjectId: StateFlow<Long?> = _mutableStateFlow

    fun setPrimarySubjectId(primarySubjectId: Long?) {
        _mutableStateFlow.value = primarySubjectId
    }

    val isPrimarySubjectSet
        get() = _mutableStateFlow.value != null

    fun commitPrimarySubject() {
        CoroutineScope(Dispatchers.Default).launch {
            setPrimaryElectiveSubject(
                electiveSubjectId.first(),
                primarySubjectId.value
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            electiveSubjectId: Long,
            primarySubjectId: Long?,
        ): NewSelectableElectiveSubjectsViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given electiveSubjectId: $selectableSubjectId is invalid"
}