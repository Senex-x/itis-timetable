package com.senex.timetable.ui.fragments.groups

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
import com.senex.timetable.ui.fragments.groups.recycler.GroupsRecyclerAdapter
import com.senex.timetable.utils.toast
import com.senex.timetable.viewmodels.GroupsViewModel

class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel: GroupsViewModel by viewModels()

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
            submitList(viewModel.groups)
            onItemClickListener = onGroupItemClick
        }
    }

    private val onGroupItemClick: (Long) -> Unit = {
        val group = viewModel.getGroup(it)
        requireContext().toast("Group ${group.name} selected")
    }

    private fun navigateToGroupsFragment() {
        findNavController().navigate(
            R.id.action_groupsFragment_to_tableFragment
        )
    }
}