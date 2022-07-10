package com.senex.timetable.presentation.ui.subject.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSubjectBinding
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SubjectFragment : BindingFragment<FragmentSubjectBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSubjectBinding =
        FragmentSubjectBinding::inflate

    private val args: SubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SubjectViewModel.Factory
    private val viewModel: SubjectViewModel by assistedViewModel {
        factory.create(args.subjectId)
    }

    override fun FragmentSubjectBinding.onViewCreated() {
        toolbarContainer.toolbar.setupWithNavController(findNavController())
        toolbarContainer.toolbar.title = resources.getString(R.string.subject_title)

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