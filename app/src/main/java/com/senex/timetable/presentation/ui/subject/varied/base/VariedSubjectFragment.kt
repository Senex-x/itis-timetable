package com.senex.timetable.presentation.ui.subject.varied.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentVariedSubjectBinding
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.ui.subject.common.initShowHideSubjectButtons
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class VariedSubjectFragment<T : VariedSubject> :
    BindingFragment<FragmentVariedSubjectBinding>() {

    protected abstract val viewModel: VariedSubjectViewModel<T>

    protected abstract val selectionFragmentNavDirections: suspend () -> NavDirections

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVariedSubjectBinding =
        FragmentVariedSubjectBinding::inflate

    override fun FragmentVariedSubjectBinding.onViewCreated() = onViewCreatedImpl(this)

    @CallSuper
    protected fun onViewCreatedImpl(
        binding: FragmentVariedSubjectBinding,
    ): Unit = with(binding) {
        subjectShowHideButtons.initShowHideSubjectButtons(
            viewLifecycleOwner.lifecycleScope,
            viewModel.isVariedSubjectVisible,
            viewModel::setSubjectVisibility,
        )
        chooseCourseButton.setOnClickListener {
            lifecycleScope.launch {
                findNavController().navigate(selectionFragmentNavDirections())
            }
        }
        toolbarContainer.toolbar.setupWithNavController(findNavController())

        viewModel.primarySubject.onEach {
            with(subjectInfo) {
                if(it != null) {
                    subjectInfo.root.visibility = View.VISIBLE
                    subjectIsNotSelectedHint.visibility = View.GONE

                    name.text = it.name
                    startTime.text = it.startTime
                    endTime.text = it.endTime
                    room.text = it.room
                    type.text = getString(it.type.nameStringId)
                    kind.text = getString(it.kind.nameStringId)
                    fullProfessorName.text = it.fullProfessorName
                } else {
                    subjectInfo.root.visibility = View.GONE
                    subjectIsNotSelectedHint.visibility = View.VISIBLE
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}