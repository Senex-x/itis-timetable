package com.senex.timetable.presentation.ui.groups

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.senex.timetable.R
import com.senex.timetable.databinding.FragmentGroupsBinding
import com.senex.timetable.domain.util.toast
import com.senex.timetable.presentation.common.BindingFragment
import com.senex.timetable.presentation.ui.groups.recycler.GroupsRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.GroupsRecyclerItemDiffCallback
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroupsFragment : BindingFragment<FragmentGroupsBinding>() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: GroupsViewModel by viewModels(factoryProducer = { factory })

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGroupsBinding =
        FragmentGroupsBinding::inflate

    override fun FragmentGroupsBinding.onViewCreated() {
        groupsToolbar.setupWithNavController(findNavController())

        groupsToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_open_schedule_fragment -> {
                    navigateToScheduleFragment()
                    true
                }
                else -> false
            }
        }

        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        groupsRecyclerView.adapter = AsyncListDifferDelegationAdapter(
            GroupsRecyclerItemDiffCallback,
            GroupsRecyclerItem.GroupItem.getDelegate(onGroupItemClick),
            GroupsRecyclerItem.CourseItem.getDelegate(),
        ).apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.groupsRecyclerItems.collect {
                    if(it.isNotEmpty())
                        loadingIndicator.visibility = View.GONE
                    else
                        loadingIndicator.visibility = View.VISIBLE
                    items = it
                }
            }
        }
    }

    private val onGroupItemClick: (Long) -> Unit = {
        viewModel.setPrimaryGroup(it)
        navigateToScheduleFragment()
    }

    private fun navigateToScheduleFragment() = findNavController().navigate(
        GroupsFragmentDirections.actionGroupsFragmentToScheduleFragment()
    )
}