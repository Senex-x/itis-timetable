package com.senex.timetable.presentation.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.presentation.common.log
import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.data.repository.local.HiddenSubjectRepositoryImpl
import com.senex.timetable.data.repository.local.SubjectRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val subjectRepository: SubjectRepositoryImpl,
    private val hiddenSubjectRepository: HiddenSubjectRepositoryImpl,
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