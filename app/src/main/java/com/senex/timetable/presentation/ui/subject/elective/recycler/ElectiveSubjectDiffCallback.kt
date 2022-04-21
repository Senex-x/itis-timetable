package com.senex.timetable.presentation.ui.subject.elective.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItem

object ElectiveSubjectDiffCallback : DiffUtil.ItemCallback<Subject>() {
    override fun areItemsTheSame(
        oldItem: Subject,
        newItem: Subject
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Subject,
        newItem: Subject
    ) = oldItem == newItem
}