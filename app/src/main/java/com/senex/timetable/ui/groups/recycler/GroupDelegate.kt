package com.senex.timetable.ui.groups.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.senex.timetable.common.log
import com.senex.timetable.common.recycler.TypedRecyclerItem
import com.senex.timetable.databinding.ListItemGroupBinding
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItem

class GroupDelegate(
    private val onItemClickListener: ((Long) -> Unit)? = null
) : AbsListItemAdapterDelegate<GroupRecyclerItem, TypedRecyclerItem, GroupDelegate.GroupViewHolder>() {

    public override fun isForViewType(
        item: TypedRecyclerItem,
        items: MutableList<TypedRecyclerItem>,
        position: Int,
    ) = item is GroupRecyclerItem

    override fun onCreateViewHolder(
        parent: ViewGroup,
    ) = GroupViewHolder(
        ListItemGroupBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        item: GroupRecyclerItem,
        holder: GroupViewHolder,
        payloads: MutableList<Any>,
    ) = holder.bind(item)

    inner class GroupViewHolder(
        private val binding: ListItemGroupBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GroupRecyclerItem) = with(binding) {
            val group = item.group

            name.text = group.name

            root.setOnClickListener {
                onItemClickListener?.invoke(group.id)
            }
        }
    }
}
