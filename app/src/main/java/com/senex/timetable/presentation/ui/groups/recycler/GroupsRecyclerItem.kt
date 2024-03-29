package com.senex.timetable.presentation.ui.groups.recycler

import android.view.View
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.senex.timetable.databinding.ListItemCourseBinding
import com.senex.timetable.databinding.ListItemGroupBinding
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.presentation.common.DelegateInflater

sealed class GroupsRecyclerItem {

    data class GroupItem(
        val group: Group,
        val isSchedulePresent: Boolean,
    ) : GroupsRecyclerItem() {
        companion object {
            fun getDelegate(
                itemClickedListener: (Long) -> Unit,
            ) = adapterDelegateViewBinding<GroupItem, GroupsRecyclerItem, ListItemGroupBinding>(
                DelegateInflater(ListItemGroupBinding::inflate)::inflate
            ) {
                binding.root.setOnClickListener {
                    itemClickedListener(item.group.id)
                }

                bind {
                    binding.subjectName.text = item.group.name
                    binding.synchronizedGroup.visibility =
                        if (item.isSchedulePresent) View.VISIBLE
                        else View.GONE
                }
            }
        }
    }

    data class CourseItem(
        val courseNumber: Int,
    ) : GroupsRecyclerItem() {
        companion object {
            fun getDelegate() =
                adapterDelegateViewBinding<CourseItem, GroupsRecyclerItem, ListItemCourseBinding>(
                    DelegateInflater(ListItemCourseBinding::inflate)::inflate
                ) {
                    bind {
                        binding.courseNumber.text = item.courseNumber.toString()
                    }
                }
        }
    }
}