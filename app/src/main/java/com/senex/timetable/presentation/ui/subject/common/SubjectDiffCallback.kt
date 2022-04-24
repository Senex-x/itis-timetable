package com.senex.timetable.presentation.ui.subject.common

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.domain.model.subject.Subject

object SubjectDiffCallback : DiffUtil.ItemCallback<Subject>() {
    override fun areItemsTheSame(
        oldItem: Subject,
        newItem: Subject
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Subject,
        newItem: Subject
    ) = oldItem == newItem
}