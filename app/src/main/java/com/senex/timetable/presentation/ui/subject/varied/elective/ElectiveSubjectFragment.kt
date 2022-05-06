package com.senex.timetable.presentation.ui.subject.varied.elective

import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
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

    override val selectionFragmentNavDirections: suspend () -> NavDirections = {
        ElectiveSubjectFragmentDirections.actionNewElectiveSubjectFragmentToNewSelectableElectiveSubjectsFragment(
            args.electiveSubjectId,
            viewModel.variedSubject.first().primarySubjectId ?: -1,
        )
    }
}


