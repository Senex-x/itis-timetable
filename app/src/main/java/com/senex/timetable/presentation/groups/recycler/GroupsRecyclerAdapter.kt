package com.senex.timetable.presentation.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.*
import com.senex.timetable.presentation.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.utils.recycler.TypedRecyclerItem
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem

class GroupsRecyclerAdapter : ListAdapter<TypedRecyclerItem, RecyclerView.ViewHolder>(
    GroupDiffCallback
) {
    var onItemClickListener: ((Long) -> Unit)? = null

    inner class CourseViewHolder(
        private val binding: ListItemCourseBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypedRecyclerItem): Unit = with(binding) {
            val courseItem = item as CourseRecyclerItem

            number.text = courseItem.courseNumber.toString()
        }
    }

    inner class GroupViewHolder(
        private val binding: ListItemGroupBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypedRecyclerItem): Unit = with(binding) {
            val group = (item as GroupRecyclerItem).group

            name.text = group.name

            root.setOnClickListener {
                onItemClickListener?.invoke(group.id)
            }
        }
    }

    override fun getItemViewType(position: Int) =
        getItem(position).getViewType()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = when (viewType) {
        GroupRecyclerItemType.COURSE.value -> CourseViewHolder(
            ListItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        GroupRecyclerItemType.GROUP.value -> GroupViewHolder(
            ListItemGroupBinding.inflate(
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
        GroupRecyclerItemType.COURSE.value ->
            (holder as CourseViewHolder)
                .bind(getItem(position))

        GroupRecyclerItemType.GROUP.value ->
            (holder as GroupViewHolder)
                .bind(getItem(position))

        else -> throw IllegalArgumentException()
    }
}