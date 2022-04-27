package com.senex.timetable.presentation.ui.subject.varied.base.selectable

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.usecase.subject.GetAllByVariedSubjectId
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.SetPrimaryVariedSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class SelectableVariedSubjectsViewModel<T : VariedSubject>(
    selectableSubjectId: Long,
    savedPrimarySubjectId: Long?,
    private val setPrimaryVariedSubject: SetPrimaryVariedSubject<T>,
    getVariedSubject: GetVariedSubject<T>,
    getAllByVariedSubjectId: GetAllByVariedSubjectId,
) : ViewModel() {
    private val variedSubjectId = getVariedSubject(selectableSubjectId).map {
        it?.id ?: throw IllegalArgumentException(invalidIdMessage)
    }

    val variedSubjects = getAllByVariedSubjectId(selectableSubjectId)

    private val _mutableStateFlow = MutableStateFlow(savedPrimarySubjectId)
    val primarySubjectId: StateFlow<Long?> = _mutableStateFlow

    fun setPrimarySubjectId(primarySubjectId: Long?) {
        _mutableStateFlow.value = primarySubjectId
    }

    val isPrimarySubjectSet
        get() = _mutableStateFlow.value != null

    fun commitPrimarySubject() {
        CoroutineScope(Dispatchers.Default).launch {
            setPrimaryVariedSubject(
                variedSubjectId.first(),
                primarySubjectId.value
            )
        }
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given electiveSubjectId: $selectableSubjectId is invalid"
}