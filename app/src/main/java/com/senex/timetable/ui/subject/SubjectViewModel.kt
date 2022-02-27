package com.senex.timetable.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.common.log
import com.senex.timetable.data.models.subject.HiddenSubject
import com.senex.timetable.data.models.subject.Subject
import com.senex.timetable.data.repositories.HiddenSubjectRepository
import com.senex.timetable.data.repositories.SubjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository,
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) : ViewModel() {
    lateinit var subject: Subject
        private set

    private var isSubjectVisible: Boolean = true

    private suspend fun isSubjectVisible() =
        hiddenSubjectRepository.get(subject.id) == null

    var subjectVisibilityChangeListener: ((Boolean) -> Unit)? = null
        set(listener) = listener.let {
            listener?.invoke(isSubjectVisible) ?: Unit
            field = listener
        }

    suspend fun setSubject(subjectId: Long) {
        subject = subjectRepository.get(subjectId)!!
        isSubjectVisible = isSubjectVisible()
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        isSubjectVisible = isVisible
        log(subjectVisibilityChangeListener.toString())
        subjectVisibilityChangeListener?.invoke(isVisible)

        if (isVisible)
            showSubject(subject.id)
        else
            hideSubject(subject.id)
    }

    private fun hideSubject(subjectId: Long) {
        CoroutineScope(Dispatchers.Default).launch {
            hiddenSubjectRepository.insert(HiddenSubject(subjectId))
        }
    }

    private fun showSubject(subjectId: Long) {
        CoroutineScope(Dispatchers.Default).launch {
            hiddenSubjectRepository.delete(subjectId)
        }
    }
}