package com.senex.timetable.ui.fragments.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.GroupListItemBinding
import com.senex.timetable.models.entities.Group

class GroupsRecyclerAdapter(
    private val items: List<Group>,
) : RecyclerView.Adapter<GroupsRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: GroupListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Group): Unit = with(binding) {
            groupName.text = item.name
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
        items[position]
    )

    override fun getItemCount() = items.size
}