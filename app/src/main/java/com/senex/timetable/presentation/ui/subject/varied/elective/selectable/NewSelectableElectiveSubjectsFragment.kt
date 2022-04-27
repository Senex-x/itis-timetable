package com.senex.timetable.presentation.ui.subject.varied.elective.selectable

import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.SelectableVariedSubjectsFragment
import javax.inject.Inject

class NewSelectableElectiveSubjectsFragment :
    SelectableVariedSubjectsFragment<ElectiveSubject>() {
    private val args: NewSelectableElectiveSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewSelectableElectiveSubjectsViewModel.Factory
    override val viewModel: NewSelectableElectiveSubjectsViewModel by assistedViewModel {
        factory.create(
            args.electiveSubjectId,
            args.primaryElectiveSubjectId.takeIf { it != -1L }
        )
    }
}