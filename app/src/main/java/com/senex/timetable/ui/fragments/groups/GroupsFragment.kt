package com.senex.timetable.ui.fragments.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentGroupsBinding
import com.senex.timetable.models.repositories.EntityRepository
import com.senex.timetable.ui.fragments.groups.recycler.GroupsRecyclerAdapter

class GroupsFragment : Fragment() {
    private var _binding: FragmentGroupsBinding? = null
    private val binding
        get() = _binding!!

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
        groupsRecyclerView.adapter = GroupsRecyclerAdapter(EntityRepository.getGroups(10))
    }

    private fun navigateToGroupsFragment() {
        findNavController().navigate(
            R.id.action_groupsFragment_to_tableFragment
        )
    }
}