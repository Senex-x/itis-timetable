package com.senex.timetable.presentation.ui.subject.varied.elective.selectable

import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.base.selectable.SelectableVariedSubjectsFragment
import javax.inject.Inject

class SelectableElectiveSubjectsFragment :
    SelectableVariedSubjectsFragment<ElectiveSubject>() {
    private val args: SelectableElectiveSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SelectableElectiveSubjectsViewModel.Factory
    override val viewModel: SelectableElectiveSubjectsViewModel by assistedViewModel {
        factory.create(
            args.electiveSubjectId,
            args.primaryElectiveSubjectId.takeIf { it != -1L }
        )
    }
}