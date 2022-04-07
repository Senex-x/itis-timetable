package com.senex.timetable.presentation.ui.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.senex.timetable.databinding.ListItemCourseBinding
import com.senex.timetable.databinding.ListItemGroupBinding
import com.senex.timetable.domain.model.group.Group

sealed class GroupsRecyclerItem {

    data class GroupItem(
        val group: Group,
    ) : GroupsRecyclerItem() {

        companion object {
            fun getDelegate(
                itemClickedListener: (Long) -> Unit,
            ) = adapterDelegateViewBinding<GroupItem, GroupsRecyclerItem, ListItemGroupBinding>(
                Inflater(ListItemGroupBinding::inflate)::inflate
            ) {
                binding.root.setOnClickListener {
                    itemClickedListener(item.group.id)
                }

                bind {
                    binding.name.text = item.group.name
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
                    Inflater(ListItemCourseBinding::inflate)::inflate
                ) {
                    bind {
                        binding.number.text = item.courseNumber.toString()
                    }
                }
        }
    }

    private class Inflater<T : ViewBinding>(
        private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
    ) {
        fun inflate(layoutInflater: LayoutInflater, root: ViewGroup) =
            bindingInflater(layoutInflater, root, false)
    }
}