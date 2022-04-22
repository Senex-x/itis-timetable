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
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
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
        initToolbar()

        val subject = viewModel.subject
        lifecycleScope.launch {
            subject.collect {
                // Draw ui
                idText.text = it.id.toString()
            }
        }

        lifecycleScope.launch {
            viewModel.isSubjectVisible.collect {
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

    private fun FragmentOrdinarySubjectBinding.initToolbar() {
        toolbarContainer.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}