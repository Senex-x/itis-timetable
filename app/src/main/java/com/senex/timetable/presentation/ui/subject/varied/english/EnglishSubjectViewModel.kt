package com.senex.timetable.presentation.ui.subject.varied.english

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.usecase.subject.GetAllByEnglishSubjectId
import com.senex.timetable.domain.usecase.subject.english.GetEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.HideEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.ShowEnglishSubject
import com.senex.timetable.presentation.ui.subject.varied.base.VariedSubjectViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class EnglishSubjectViewModel @AssistedInject constructor(
    @Assisted englishSubjectId: Long,
    showEnglishSubject: ShowEnglishSubject,
    hideEnglishSubject: HideEnglishSubject,
    getEnglishSubject: GetEnglishSubject,
    getAllByEnglishSubjectId: GetAllByEnglishSubjectId,
) : VariedSubjectViewModel<EnglishSubject>(
    englishSubjectId,
    showEnglishSubject,
    hideEnglishSubject,
    getEnglishSubject,
    getAllByEnglishSubjectId,
) {
    @AssistedFactory
    interface Factory {
        fun create(englishSubjectId: Long): EnglishSubjectViewModel
    }
}