package com.senex.timetable.presentation.ui.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.senex.timetable.common.recycler.TypedRecyclerItem
import com.senex.timetable.databinding.ListItemCourseBinding
import com.senex.timetable.presentation.ui.groups.recycler.items.CourseRecyclerItem

class CourseDelegate :
    AbsListItemAdapterDelegate<CourseRecyclerItem, TypedRecyclerItem, CourseDelegate.CourseViewHolder>() {

    public override fun isForViewType(
        item: TypedRecyclerItem,
        items: MutableList<TypedRecyclerItem>,
        position: Int,
    ) = item is CourseRecyclerItem

    override fun onCreateViewHolder(
        parent: ViewGroup,
    ) = CourseViewHolder(
        ListItemCourseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        item: CourseRecyclerItem,
        holder: CourseViewHolder,
        payloads: MutableList<Any>,
    ) = holder.bind(item)

    class CourseViewHolder(
        private val binding: ListItemCourseBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CourseRecyclerItem) = with(binding) {
            number.text = item.courseNumber.toString()
        }
    }
}
