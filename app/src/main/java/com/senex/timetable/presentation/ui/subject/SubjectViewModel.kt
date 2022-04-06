package com.senex.timetable.presentation.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.usecase.DeleteHiddenSubjectById
import com.senex.timetable.domain.usecase.GetHiddenSubjectById
import com.senex.timetable.domain.usecase.GetSubjectById
import com.senex.timetable.domain.usecase.InsertHiddenSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SubjectViewModel @AssistedInject constructor(
    @Assisted private val subjectId: Long,
    private val insertHiddenSubject: InsertHiddenSubject,
    private val deleteHiddenSubjectById: DeleteHiddenSubjectById,
    getSubjectById: GetSubjectById,
    getHiddenSubjectById: GetHiddenSubjectById,
) : ViewModel() {
    val subject = getSubjectById(subjectId).map {
        it ?: throw IllegalArgumentException("Given subjectId: $subjectId is invalid")
    }

    val isSubjectVisible = getHiddenSubjectById(subjectId).map {
        it == null
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        CoroutineScope(Dispatchers.Default).launch {
            if (isVisible)
                showSubject(subjectId)
            else
                hideSubject(subjectId)
        }
    }

    private suspend fun hideSubject(subjectId: Long) =
        insertHiddenSubject(HiddenSubject(subjectId))

    private suspend fun showSubject(subjectId: Long) =
        deleteHiddenSubjectById(subjectId)

    @AssistedFactory
    interface Factory {
        fun create(subjectId: Long): SubjectViewModel
    }
}