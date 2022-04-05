package com.senex.timetable.presentation.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.usecase.DeleteHiddenSubjectById
import com.senex.timetable.domain.usecase.GetHiddenSubjectById
import com.senex.timetable.domain.usecase.GetSubjectById
import com.senex.timetable.domain.usecase.InsertHiddenSubject
import com.senex.timetable.domain.util.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val getSubjectById: GetSubjectById,
    private val getHiddenSubjectById: GetHiddenSubjectById,
    private val insertHiddenSubject: InsertHiddenSubject,
    private val deleteHiddenSubjectById: DeleteHiddenSubjectById,
) : ViewModel() {
    lateinit var subject: Subject
        private set

    private var isSubjectVisible: Boolean = true

    private suspend fun isSubjectVisible() =
        getHiddenSubjectById(subject.id).first() == null

    var subjectVisibilityChangeListener: ((Boolean) -> Unit)? = null
        set(listener) = listener.let {
            listener?.invoke(isSubjectVisible) ?: Unit
            field = listener
        }

    suspend fun setSubject(subjectId: Long) {
        subject = getSubjectById(subjectId).first()!!
        isSubjectVisible = isSubjectVisible()
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        isSubjectVisible = isVisible
        subjectVisibilityChangeListener?.invoke(isVisible)

        if (isVisible)
            showSubject(subject.id)
        else
            hideSubject(subject.id)
    }

    private fun hideSubject(subjectId: Long) {
        CoroutineScope(Dispatchers.Default).launch {
            insertHiddenSubject(HiddenSubject(subjectId))
        }
    }

    private fun showSubject(subjectId: Long) {
        CoroutineScope(Dispatchers.Default).launch {
            deleteHiddenSubjectById(subjectId)
        }
    }
}