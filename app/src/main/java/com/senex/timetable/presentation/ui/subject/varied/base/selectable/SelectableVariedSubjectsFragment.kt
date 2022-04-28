package com.senex.timetable.presentation.ui.subject.varied.base.selectable

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.CallSuper
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSelectableVariedSubjectsBinding
import com.senex.timetable.domain.model.subject.VariedSubject
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.ui.subject.common.setMenuItemColor
import com.senex.timetable.presentation.ui.subject.common.varied.SelectableVariedSubjectsRecyclerAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class SelectableVariedSubjectsFragment<T : VariedSubject> :
    BindingFragment<FragmentSelectableVariedSubjectsBinding>() {

    protected abstract val viewModel: SelectableVariedSubjectsViewModel<T>

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectableVariedSubjectsBinding =
        FragmentSelectableVariedSubjectsBinding::inflate

    @CallSuper
    override fun FragmentSelectableVariedSubjectsBinding.onViewCreated() {
        toolbar.initToolbar()
        selectableSubjectsRecycler.initRecycler()
        selectNothingButton.initSelectNothingButton()
    }

    private fun MaterialToolbar.initToolbar() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.primarySubjectId.collect {
                setMenuItemColor(
                    R.id.action_confirm,
                    if (it != null) R.color.primary else R.color.gray,
                )
            }
        }
        setupWithNavController(findNavController())
        setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_confirm -> commitSelection()
                else -> false
            }
        }
    }

    private fun commitSelection(): Boolean {
        if (viewModel.isPrimarySubjectSet) {
            commitAndPopBackStack()
        } else {
            requireContext().toast(getString(R.string.course_is_not_selected_message))
        }
        return true
    }

    private fun RecyclerView.initRecycler() {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = SelectableVariedSubjectsRecyclerAdapter(
            onItemCheckedChangeListener,
            viewModel.primarySubjectId.value
        ).apply {
            viewModel.variedSubjects
                .onEach(::submitList)
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private val onItemCheckedChangeListener = { isChecked: Boolean, subjectId: Long ->
        if (isChecked) {
            viewModel.setPrimarySubjectId(subjectId)
        } else if (viewModel.primarySubjectId.value == subjectId) {
            viewModel.setPrimarySubjectId(null)
        }
    }

    private fun Button.initSelectNothingButton() = setOnClickListener {
        viewModel.setPrimarySubjectId(null)
        commitAndPopBackStack()
    }

    private fun commitAndPopBackStack() {
        viewModel.commitPrimarySubject()
        popBackStack()
    }

    private fun popBackStack() = findNavController().popBackStack()
}