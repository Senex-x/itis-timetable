package com.senex.timetable.presentation.ui.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
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
                { layoutInflater, root ->
                    inflateBinding(layoutInflater, root, ListItemGroupBinding::inflate)
                }

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
                    { layoutInflater, root ->
                        inflateBinding(layoutInflater, root, ListItemCourseBinding::inflate)
                    }
                ) {
                    bind {
                        binding.number.text = item.courseNumber.toString()
                    }
                }
        }
    }

    companion object {
        private fun <T> inflateBinding(
            layoutInflater: LayoutInflater,
            root: ViewGroup,
            bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
        ) = bindingInflater.invoke(layoutInflater, root, false)
    }
}
