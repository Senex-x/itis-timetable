package com.senex.timetable.presentation.ui.subject.single

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetSubjectById
import com.senex.timetable.domain.usecase.subject.HideSubject
import com.senex.timetable.domain.usecase.subject.ShowSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SubjectViewModel @AssistedInject constructor(
    @Assisted private val subjectId: Long,
    private val showSubject: ShowSubject,
    private val hideSubject: HideSubject,
    getSubjectById: GetSubjectById,
) : ViewModel() {
    val subject = getSubjectById(subjectId).map {
        it ?: throw IllegalArgumentException("Given subjectId: $subjectId is invalid")
    }

    val isSubjectVisible = subject.map {
        it.isVisible
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        CoroutineScope(Dispatchers.Default).launch {
            if (isVisible)
                showSubject(subjectId)
            else
                hideSubject(subjectId)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(subjectId: Long): SubjectViewModel
    }
}