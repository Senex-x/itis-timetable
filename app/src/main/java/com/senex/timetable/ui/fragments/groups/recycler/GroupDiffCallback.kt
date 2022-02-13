package com.senex.timetable.ui.fragments.groups.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.model.entities.Group

object GroupDiffCallback : DiffUtil.ItemCallback<Group>() {
    override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
        return oldItem == newItem
    }
}