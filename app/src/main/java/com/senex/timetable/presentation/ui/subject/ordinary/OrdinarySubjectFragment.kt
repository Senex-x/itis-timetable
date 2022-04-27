package com.senex.timetable.presentation.ui.subject.ordinary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.databinding.FragmentOrdinarySubjectBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OrdinarySubjectFragment : BindingFragment<FragmentOrdinarySubjectBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOrdinarySubjectBinding =
        FragmentOrdinarySubjectBinding::inflate

    private val args: OrdinarySubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: OrdinarySubjectViewModel.Factory
    private val viewModel: OrdinarySubjectViewModel by assistedViewModel {
        factory.create(args.subjectId)
    }

    override fun FragmentOrdinarySubjectBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())

        viewModel.subject.onEach {
            with(subjectInfo) {
                name.text = it.name
                startTime.text = it.startTime
                endTime.text = it.endTime
                room.text = it.room
                type.text = getString(it.type.nameStringId)
                kind.text = getString(it.kind.nameStringId)
                fullProfessorName.text = it.fullProfessorName
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isSubjectVisible,
            viewModel::setSubjectVisibility,
        )
    }
}