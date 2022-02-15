package com.senex.timetable.presentation.groups

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentGroupsBinding
import com.senex.timetable.presentation.groups.recycler.GroupsRecyclerAdapter
import com.senex.timetable.utils.SharedPreferencesHandler
import com.senex.timetable.utils.toast

class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: GroupsViewModel by viewModels()
    //TODO: move to viewmodel
    private val preferences by lazy {
        SharedPreferencesHandler(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGroupsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ): Unit = with(binding) {
        groupsToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    navigateToGroupsFragment()
                    true
                }
                else -> false
            }
        }

        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        groupsRecyclerView.adapter = GroupsRecyclerAdapter().apply {
            viewModel.groups.observe(viewLifecycleOwner) {
                submitList(it)
            }
            onItemClickListener = onGroupItemClick
        }
    }

    private val onGroupItemClick: (Long) -> Unit = {
        val group = viewModel.getGroup(it)
        requireContext().toast("Group ${group.name} selected")
        preferences.saveGroupId(group.id)
    }

    private fun navigateToGroupsFragment() {
        findNavController().navigate(
            R.id.action_groupsFragment_to_tableFragment
        )
    }
}