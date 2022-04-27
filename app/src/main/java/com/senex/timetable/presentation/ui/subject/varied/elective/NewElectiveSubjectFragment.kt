package com.senex.timetable.presentation.ui.subject.varied.elective

import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.varied.VariedSubjectFragment
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewElectiveSubjectFragment : VariedSubjectFragment<ElectiveSubject>() {

    private val args: NewElectiveSubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewElectiveSubjectViewModel.Factory
    override val viewModel: NewElectiveSubjectViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override val selectionFragmentNavDirections: suspend () -> NavDirections = {
        NewElectiveSubjectFragmentDirections.actionNewElectiveSubjectFragmentToNewSelectableElectiveSubjectsFragment(
            args.electiveSubjectId,
            viewModel.variedSubject.first().primarySubjectId ?: -1,
        )
    }
}


