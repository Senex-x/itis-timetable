package com.senex.timetable.presentation.ui.subject.varied.english.selectable

import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.base.selectable.SelectableVariedSubjectsFragment
import javax.inject.Inject

class SelectableEnglishSubjectsFragment :
    SelectableVariedSubjectsFragment<EnglishSubject>() {
    private val args: SelectableEnglishSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SelectableEnglishSubjectsViewModel.Factory
    override val viewModel: SelectableEnglishSubjectsViewModel by assistedViewModel {
        factory.create(
            args.englishSubjectId,
            args.primaryEnglishSubjectId.takeIf { it != -1L }
        )
    }
}