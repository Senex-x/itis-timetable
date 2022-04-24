package com.senex.timetable.presentation.ui.subject.ordinary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.databinding.FragmentOrdinarySubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.common.initNavToolbar
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OrdinarySubjectFragment : DaggerFragment() {
    private var _binding: FragmentOrdinarySubjectBinding? = null
    private val binding
        get() = _binding!!

    private val args: OrdinarySubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: OrdinarySubjectViewModel.Factory
    private val viewModel: OrdinarySubjectViewModel by assistedViewModel {
        factory.create(args.subjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentOrdinarySubjectBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        toolbarContainer.toolbar.initNavToolbar(findNavController())

        viewModel.subject.onEach {
            name.text = it.name
            startTime.text = it.startTime
            endTime.text = it.endTime
            room.text = it.room
            type.text = getString(it.type.nameStringId)
            kind.text = getString(it.kind.nameStringId)
            fullProfessorName.text = it.fullProfessorName
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isSubjectVisible,
            viewModel::setSubjectVisibility,
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}