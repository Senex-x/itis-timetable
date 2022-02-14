package com.senex.timetable.presentation.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.GroupCourseListItemBinding
import com.senex.timetable.databinding.GroupListItemBinding
import com.senex.timetable.presentation.groups.recycler.items.CourseItem
import com.senex.timetable.presentation.groups.recycler.items.GroupItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItemType

class GroupsRecyclerAdapter : ListAdapter<GroupListItem, RecyclerView.ViewHolder>(
    GroupDiffCallback
) {
    var onItemClickListener: ((Long) -> Unit)? = null

    inner class CourseViewHolder(
        private val binding: GroupCourseListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GroupListItem): Unit = with(binding) {
            val courseItem = item as CourseItem

            number.text = courseItem.courseNumber.toString()
        }
    }

    inner class GroupViewHolder(
        private val binding: GroupListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GroupListItem): Unit = with(binding) {
            val group = (item as GroupItem).group

            name.text = group.name

            root.setOnClickListener {
                onItemClickListener?.invoke(group.id!!)
            }
        }
    }

    override fun getItemViewType(position: Int) =
        getItem(position).getViewType()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = when (viewType) {
        GroupListItemType.COURSE.value -> CourseViewHolder(
            GroupCourseListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        GroupListItemType.GROUP.value -> GroupViewHolder(
            GroupListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
        else -> throw IllegalArgumentException()
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) = when (holder.itemViewType) {
        GroupListItemType.COURSE.value ->
            (holder as CourseViewHolder)
                .bind(getItem(position))

        GroupListItemType.GROUP.value ->
            (holder as GroupViewHolder)
                .bind(getItem(position))

        else -> throw IllegalArgumentException()
    }
}