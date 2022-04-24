package com.senex.timetable.presentation.ui.subject.english

import androidx.lifecycle.ViewModel
import com.senex.timetable.domain.usecase.subject.GetAllByEnglishSubjectId
import com.senex.timetable.domain.usecase.subject.english.GetEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.HideEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.ShowEnglishSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class EnglishSubjectViewModel @AssistedInject constructor(
    @Assisted private val englishSubjectId: Long,
    private val showEnglishSubject: ShowEnglishSubject,
    private val hideEnglishSubject: HideEnglishSubject,
    getEnglishSubject: GetEnglishSubject,
    getAllByEnglishSubjectId: GetAllByEnglishSubjectId
) : ViewModel() {
    val englishSubject = getEnglishSubject(englishSubjectId).map {
        it ?: throw IllegalArgumentException(invalidIdMessage)
    }
    val englishSubjects = getAllByEnglishSubjectId(englishSubjectId)

    val isEnglishSubjectVisible = englishSubject.map {
        it.isVisible
    }

    fun setSubjectVisibility(isVisible: Boolean) {
        CoroutineScope(Dispatchers.Default).launch {
            if (isVisible)
                showEnglishSubject(englishSubjectId)
            else
                hideEnglishSubject(englishSubjectId)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(englishSubjectId: Long): EnglishSubjectViewModel
    }

    private val invalidIdMessage =
        "${this::class.simpleName}: Given englishSubjectId: $englishSubjectId is invalid"
}