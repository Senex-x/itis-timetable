package com.senex.timetable.presentation.ui.subject.varied.english.selectable

import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.SelectableVariedSubjectsFragment
import javax.inject.Inject

class NewSelectableEnglishSubjectsFragment :
    SelectableVariedSubjectsFragment<EnglishSubject>() {
    private val args: NewSelectableEnglishSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewSelectableEnglishSubjectsViewModel.Factory
    override val viewModel: NewSelectableEnglishSubjectsViewModel by assistedViewModel {
        factory.create(
            args.englishSubjectId,
            args.primaryEnglishSubjectId.takeIf { it != -1L }
        )
    }
}