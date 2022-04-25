package com.senex.timetable.presentation.ui.subject.varied

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByVariedSubjectId
import com.senex.timetable.domain.usecase.subject.varied.GetVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.HideVariedSubject
import com.senex.timetable.domain.usecase.subject.varied.ShowVariedSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Named

class VariedSubjectViewModel @AssistedInject constructor(
    @Assisted private val variedSubjectId: Long,
    @Named("ShowElectiveSubject") private val showVariedSubject: ShowVariedSubject,
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

    @AssistedFactory
    interface Factory {
        fun create(variedSubjectId: Long): VariedSubjectViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given variedSubjectId: $variedSubjectId is invalid"
}