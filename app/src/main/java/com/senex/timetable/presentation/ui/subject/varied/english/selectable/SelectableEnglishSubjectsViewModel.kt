package com.senex.timetable.presentation.ui.subject.varied.english.selectable

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.usecase.subject.GetAllByEnglishSubjectId
import com.senex.timetable.domain.usecase.subject.english.GetEnglishSubject
import com.senex.timetable.domain.usecase.subject.english.SetPrimaryEnglishSubject
import com.senex.timetable.presentation.ui.subject.varied.base.selectable.SelectableVariedSubjectsViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SelectableEnglishSubjectsViewModel @AssistedInject constructor(
    @Assisted englishSubjectId: Long,
    @Assisted savedPrimarySubjectId: Long?,
    setPrimaryEnglishSubject: SetPrimaryEnglishSubject,
    getEnglishSubject: GetEnglishSubject,
    getAllByEnglishSubjectId: GetAllByEnglishSubjectId,
) : SelectableVariedSubjectsViewModel<EnglishSubject>(
    englishSubjectId,
    savedPrimarySubjectId,
    setPrimaryEnglishSubject,
    getEnglishSubject,
    getAllByEnglishSubjectId,
) {
    @AssistedFactory
    interface Factory {
        fun create(
            englishSubjectId: Long,
            primarySubjectId: Long?,
        ): SelectableEnglishSubjectsViewModel
    }
}