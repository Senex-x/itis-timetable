package com.senex.timetable.presentation.ui.subject.varied.base

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.usecase.subject.GetAllByVariedSubjectId
import com.senex.timetable.domain.usecase.subject.GetPrimarySubject
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

abstract class VariedSubjectViewModel<T : VariedSubject>(
    private val variedSubjectId: Long,
    private val showVariedSubject: ShowVariedSubject<T>,
    private val hideVariedSubject: HideVariedSubject<T>,
    getVariedSubject: GetVariedSubject<T>,
    getAllByVariedSubjectId: GetAllByVariedSubjectId,
    getPrimarySubject: GetPrimarySubject,
) : ViewModel() {
    val variedSubject = getVariedSubject(variedSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val variedSubjects = getAllByVariedSubjectId(variedSubjectId)

    val primarySubject = variedSubject.transform {
        it.primarySubjectId?.let { id ->
            getPrimarySubject(id).collect { primarySubject ->
                emit(primarySubject)
            }
        } ?: emit(null)
    }

    val isVariedSubjectVisible = variedSubject.map {
        it.isVisible
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        CoroutineScope(Dispatchers.Default).launch {
            if (isVisible)
                showVariedSubject(variedSubjectId)
            else
                hideVariedSubject(variedSubjectId)
        }
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given variedSubjectId: $variedSubjectId is invalid"
}