package com.senex.timetable.presentation.ui.subject.elective

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ElectiveSubjectViewModel @AssistedInject constructor(
    @Assisted private val electiveSubjectId: Long,
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(electiveSubjectId: Long): ElectiveSubjectViewModel
    }
}