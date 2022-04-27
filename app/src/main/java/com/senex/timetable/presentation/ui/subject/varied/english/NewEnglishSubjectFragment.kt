package com.senex.timetable.presentation.ui.subject.varied.english

import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.VariedSubjectFragment
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class NewEnglishSubjectFragment : VariedSubjectFragment<EnglishSubject>() {
    private val args: NewEnglishSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewEnglishSubjectViewModel.Factory
    override val viewModel: NewEnglishSubjectViewModel by assistedViewModel {
        factory.create(args.englishSubjectId)
    }

    override val selectionFragmentNavDirections: suspend () -> NavDirections = {
        NewEnglishSubjectFragmentDirections.actionNewEnglishSubjectFragmentToNewSelectableEnglishSubjectsFragment(
            args.englishSubjectId,
            viewModel.variedSubject.first().primarySubjectId ?: -1,
        )
    }

}


