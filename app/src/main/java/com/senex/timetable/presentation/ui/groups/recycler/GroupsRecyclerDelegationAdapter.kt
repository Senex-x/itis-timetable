package com.senex.timetable.presentation.ui.groups.recycler

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.senex.timetable.databinding.ListItemGroupBinding
import com.senex.timetable.presentation.common.recycler.TypedRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem

class GroupsRecyclerDelegationAdapter(
    private val onItemClickListener: ((Long) -> Unit)? = null,
) : AsyncListDifferDelegationAdapter<TypedRecyclerItem>(
    GroupDiffCallback
) {
    init {
        delegatesManager
            .addDelegate(groupItemAdapterDelegate(onItemClickListener))
            .addDelegate(CourseDelegate())
    }
}

fun groupItemAdapterDelegate(
    itemClickedListener: ((Long) -> Unit)? = null,
) = adapterDelegateViewBinding<GroupRecyclerItem, TypedRecyclerItem, ListItemGroupBinding>(
    { layoutInflater, root -> ListItemGroupBinding.inflate(layoutInflater, root, false) }
) {
    binding.root.setOnClickListener {
        itemClickedListener?.invoke(item.group.id)
    }

    bind {
        binding.name.text = item.group.name
    }
}