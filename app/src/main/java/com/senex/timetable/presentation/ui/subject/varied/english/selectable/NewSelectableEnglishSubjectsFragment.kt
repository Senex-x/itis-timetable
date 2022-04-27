package com.senex.timetable.presentation.ui.subject.varied.english.selectable

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSelectableVariedSubjectsBinding
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.ui.subject.common.setMenuItemColor
import com.senex.timetable.presentation.ui.subject.common.varied.SelectableVariedSubjectsRecyclerAdapter
import com.senex.timetable.presentation.ui.subject.varied.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewSelectableEnglishSubjectsFragment : BindingFragment<FragmentSelectableVariedSubjectsBinding>() {
    private val args: NewSelectableEnglishSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: NewSelectableEnglishSubjectsViewModel.Factory
    private val viewModel: NewSelectableEnglishSubjectsViewModel by assistedViewModel {
        factory.create(
            args.englishSubjectId,
            args.primaryEnglishSubjectId.takeIf { it != -1L }
        )
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectableVariedSubjectsBinding =
        FragmentSelectableVariedSubjectsBinding::inflate

    override val onViewCreatedCallback: FragmentSelectableVariedSubjectsBinding.() -> Unit = {
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
        setupWithNavController(
            findNavController(),
            AppBarConfiguration(findNavController().graph)
        )
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
            viewModel.englishSubjects
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