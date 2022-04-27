package com.senex.timetable.presentation.ui.subject.varied.english.selectable

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByEnglishSubjectId
import com.senex.timetable.domain.usecase.subject.english.GetEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.SetPrimaryEnglishSubject
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

class NewSelectableEnglishSubjectsViewModel @AssistedInject constructor(
    @Assisted private val selectableSubjectId: Long,
    @Assisted private val savedPrimarySubjectId: Long?,
    private val setPrimaryEnglishSubject: SetPrimaryEnglishSubject,
    getEnglishSubject: GetEnglishSubject,
    getAllByEnglishSubjectId: GetAllByEnglishSubjectId,
) : ViewModel() {
    private val englishSubjectId = getEnglishSubject(selectableSubjectId).map {
        it?.id ?: throw IllegalArgumentException(invalidIdMessage)
    }

    val englishSubjects = getAllByEnglishSubjectId(selectableSubjectId)

    private val _mutableStateFlow = MutableStateFlow(savedPrimarySubjectId)
    val primarySubjectId: StateFlow<Long?> = _mutableStateFlow

    fun setPrimarySubjectId(primarySubjectId: Long?) {
        _mutableStateFlow.value = primarySubjectId
    }

    val isPrimarySubjectSet
        get() = _mutableStateFlow.value != null

    fun commitPrimarySubject() {
        CoroutineScope(Dispatchers.Default).launch {
            setPrimaryEnglishSubject(
                englishSubjectId.first(),
                primarySubjectId.value
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            englishSubjectId: Long,
            primarySubjectId: Long?,
        ): NewSelectableEnglishSubjectsViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given englishSubjectId: $selectableSubjectId is invalid"
}