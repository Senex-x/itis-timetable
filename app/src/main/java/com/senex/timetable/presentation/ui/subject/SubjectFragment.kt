package com.senex.timetable.presentation.ui.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentSubjectBinding
import com.senex.timetable.presentation.common.assistedViewModel
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SubjectFragment : DaggerFragment() {
    private var _binding: FragmentSubjectBinding? = null
    private val binding
        get() = _binding!!

    private val args: SubjectFragmentArgs by navArgs()

    @Inject
    lateinit var factory: SubjectViewModel.Factory
    private val viewModel: SubjectViewModel by assistedViewModel {
        factory.create(args.subjectId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSubjectBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        initToolbar()

        val subject = viewModel.subject
        lifecycleScope.launch {
            subject.collect {
                // Draw ui
                idText.text = it.id.toString()
            }
        }

        val isVisible = viewModel.isSubjectVisible
        lifecycleScope.launch {
            isVisible.collect {
                // Handle visibility changes
                if (it) {
                    showSubjectButton.visibility = View.INVISIBLE
                    hideSubjectButton.visibility = View.VISIBLE
                } else {
                    showSubjectButton.visibility = View.VISIBLE
                    hideSubjectButton.visibility = View.INVISIBLE
                }
            }
        }

        hideSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = false)
        }

        showSubjectButton.setOnClickListener {
            viewModel.setSubjectVisibility(isVisible = true)
        }
    }

    private fun FragmentSubjectBinding.initToolbar() {
        groupsToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    navigateToGroupsFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToGroupsFragment() =
        findNavController().popBackStack()
}