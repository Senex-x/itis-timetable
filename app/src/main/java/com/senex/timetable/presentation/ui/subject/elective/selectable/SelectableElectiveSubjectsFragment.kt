package com.senex.timetable.presentation.ui.subject.elective.selectable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSelectableElectiveSubjectsBinding
import com.senex.timetable.presentation.common.assistedViewModel
import com.senex.timetable.presentation.common.inflateBinding
import com.senex.timetable.presentation.ui.subject.elective.selectable.recycler.SelectableElectiveSubjectsRecyclerAdapter
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SelectableElectiveSubjectsFragment : DaggerFragment() {
    private var _binding: FragmentSelectableElectiveSubjectsBinding? = null
    private val binding
        get() = _binding!!

    private val args: SelectableElectiveSubjectsFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SelectableElectiveSubjectsViewModel.Factory
    private val viewModel: SelectableElectiveSubjectsViewModel by assistedViewModel {
        factory.create(args.electiveSubjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(FragmentSelectableElectiveSubjectsBinding::inflate, inflater, container) {
        _binding = it
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        selectableElectiveSubjectsToolbar.initToolbar()
        selectableElectiveSubjectsRecycler.initRecycler()
        selectNothingButton.initSelectNothingButton()
    }

    private fun MaterialToolbar.initToolbar() {
        setNavigationOnClickListener {
            popBackStack()
        }
        setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_confirm -> confirmSelection()
                else -> false
            }
        }
    }

    private fun confirmSelection(): Boolean {
        // TODO: Handle
        popBackStack()
        return true
    }

    private fun RecyclerView.initRecycler() {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = SelectableElectiveSubjectsRecyclerAdapter(onItemCheckedChangeListener).apply {
            viewModel.electiveSubjects
                .onEach(::submitList)
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private val onItemCheckedChangeListener = { isChecked: Boolean, subjectId: Long ->
        if (isChecked) {
            viewModel.primarySubjectId = subjectId
        } else if (viewModel.primarySubjectId == subjectId) {
            viewModel.primarySubjectId = null
        }

        val toolbar = binding.selectableElectiveSubjectsToolbar
        if (viewModel.primarySubjectId != null) {
            toolbar.setConfirmMenuItemColor(R.color.primary)
        } else {
            toolbar.setConfirmMenuItemColor(R.color.gray)
        }
    }

    private fun Button.initSelectNothingButton() = setOnClickListener {
        viewModel.primarySubjectId = null
        popBackStack()
    }

    private fun popBackStack() {
        viewModel.commitPrimarySubject()
        findNavController().popBackStack()
    }

    private fun MaterialToolbar.setConfirmMenuItemColor(colorId: Int) =
        menu.findItem(R.id.action_confirm)
            .icon.setTint(resources.getColor(colorId, requireContext().theme))

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}