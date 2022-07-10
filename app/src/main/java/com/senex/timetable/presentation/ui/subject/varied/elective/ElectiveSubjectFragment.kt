package com.senex.timetable.presentation.ui.subject.varied.elective

import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.base.VariedSubjectFragment
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ElectiveSubjectFragment : VariedSubjectFragment<ElectiveSubject>() {

    private val args: ElectiveSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: ElectiveSubjectViewModel.Factory
    override val viewModel: ElectiveSubjectViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override fun FragmentVariedSubjectBinding.onViewCreated() {
        super.onViewCreatedImpl(this)

        toolbarContainer.toolbar.title = resources.getString(R.string.elective_subject_title)
        chooseCourseButton.text = getString(R.string.choose_elective_course_title)
        subjectIsNotSelectedHint.text = getString(R.string.elective_course_not_selected_hint)
    }

    override val selectionFragmentNavDirections: suspend () -> NavDirections = {
        ElectiveSubjectFragmentDirections.actionElectiveSubjectFragmentToSelectableElectiveSubjectsFragment(
            args.electiveSubjectId,
            viewModel.variedSubject.first().primarySubjectId ?: -1,
        )
    }
}


