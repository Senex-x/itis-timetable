package com.senex.timetable.ui.schedule.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.ui.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.common.recycler.TypedRecyclerItem
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItemType
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItem

// TODO: Handle payloads
object SubjectDiffCallback : DiffUtil.ItemCallback<Subject>() {
    override fun areItemsTheSame(
        oldItem: Subject,
        newItem: Subject,
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Subject,
        newItem: Subject,
    ) = oldItem == newItem
}