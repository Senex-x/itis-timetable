package com.senex.timetable.presentation.ui.subject.varied

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senex.timetable.domain.usecase.subject.GetAllByVariedSubjectId
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class BaseVariedSubjectViewModel constructor(
    private val variedSubjectId: Long,
    private val showVariedSubject: ShowVariedSubject,
    private val hideVariedSubject: HideVariedSubject,
    getVariedSubject: GetVariedSubject,
    getAllByVariedSubjectId: GetAllByVariedSubjectId,
) : ViewModel() {
    val variedSubject = getVariedSubject(variedSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val variedSubjects = getAllByVariedSubjectId(variedSubjectId)

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