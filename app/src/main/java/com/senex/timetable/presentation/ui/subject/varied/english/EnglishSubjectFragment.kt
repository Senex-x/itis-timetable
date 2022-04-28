package com.senex.timetable.presentation.ui.subject.varied.english

import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.base.VariedSubjectFragment
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class EnglishSubjectFragment : VariedSubjectFragment<EnglishSubject>() {
    private val args: EnglishSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: EnglishSubjectViewModel.Factory
    override val viewModel: EnglishSubjectViewModel by assistedViewModel {
        factory.create(args.englishSubjectId)
    }

    override fun FragmentVariedSubjectBinding.onViewCreated() {
        super.onViewCreatedImpl(this)

        chooseCourseButton.text = getString(R.string.choose_english_group_title)
        subjectIsNotSelectedHint.text = getString(R.string.english_group_not_selected_hint)
    }

    override val selectionFragmentNavDirections: suspend () -> NavDirections = {
        EnglishSubjectFragmentDirections.actionEnglishSubjectFragmentToSelectableEnglishSubjectsFragment(
            args.englishSubjectId,
            viewModel.variedSubject.first().primarySubjectId ?: -1,
        )
    }
}


