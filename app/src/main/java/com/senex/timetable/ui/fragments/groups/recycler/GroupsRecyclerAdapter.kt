package com.senex.timetable.ui.fragments.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.GroupListItemBinding
import com.senex.timetable.model.entities.Group

class GroupsRecyclerAdapter : ListAdapter<Group, GroupsRecyclerAdapter.ViewHolder>(
    GroupDiffCallback
) {
    inner class ViewHolder(
        private val binding: GroupListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Group): Unit = with(binding) {
            courseNumber.text = item.courseNumber.toString()
            name.text = item.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = ViewHolder(
        GroupListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
    ) = holder.bind(
        getItem(position)
    )
}