package com.senex.timetable.presentation.ui.schedule.daily.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.data.model.subject.Subject

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