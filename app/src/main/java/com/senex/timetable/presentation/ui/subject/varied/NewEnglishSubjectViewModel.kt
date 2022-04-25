package com.senex.timetable.presentation.ui.subject.varied

import com.senex.timetable.domain.usecase.subject.GetAllByEnglishSubjectId
import com.senex.timetable.domain.usecase.subject.english.GetEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.HideEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.ShowEnglishSubject
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class NewEnglishSubjectViewModel @AssistedInject constructor(
    @Assisted englishSubjectId: Long,
    showEnglishSubject: ShowEnglishSubject,
    hideEnglishSubject: HideEnglishSubject,
    getEnglishSubject: GetEnglishSubject,
    getAllByEnglishSubjectId: GetAllByEnglishSubjectId,
) : BaseVariedSubjectViewModel(
    englishSubjectId,
    showEnglishSubject,
    hideEnglishSubject,
    getEnglishSubject,
    getAllByEnglishSubjectId,
) {
    @AssistedFactory
    interface Factory {
        fun create(englishSubjectId: Long): NewEnglishSubjectViewModel
    }
}