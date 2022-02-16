package com.senex.timetable.presentation.schedule.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.*
import com.senex.timetable.presentation.schedule.recycler.items.*
import com.senex.timetable.presentation.schedule.recycler.items.DayRecyclerItem
import com.senex.timetable.presentation.schedule.recycler.items.ScheduleRecyclerItemType
import com.senex.timetable.presentation.schedule.recycler.items.SubjectRecyclerItem
import com.senex.timetable.utils.recycler.TypedRecyclerItem

class ScheduleRecyclerAdapter(
    private val items: List<TypedRecyclerItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class DayViewHolder(
        private val binding: ListItemDayBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TypedRecyclerItem): Unit = with(binding) {
            val dayItem = item as DayRecyclerItem

            name.text = dayItem.name
        }
    }

    inner class SubjectViewHolder(
        private val binding: ListItemScheduleBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: TypedRecyclerItem): Unit = with(binding) {
            val subjectItem = item as SubjectRecyclerItem

            period.text = subjectItem.item.startTime +
                    "\n" + subjectItem.item.endTime
            name.text = subjectItem.item.name
            type.text = subjectItem.item.type.name
            roomNumber.text = subjectItem.item.room

        }
    }

    override fun getItemViewType(position: Int) =
        items[position].getViewType()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = when (viewType) {
        ScheduleRecyclerItemType.DAY.value ->
            DayViewHolder(
                ListItemDayBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))

        ScheduleRecyclerItemType.SUBJECT.value ->
            SubjectViewHolder(
                ListItemScheduleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))

        else -> throw IllegalArgumentException()
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) = when (holder.itemViewType) {
        ScheduleRecyclerItemType.DAY.value ->
            (holder as DayViewHolder)
                .bind(items[position])

        ScheduleRecyclerItemType.SUBJECT.value ->
            (holder as SubjectViewHolder)
                .bind(items[position])

        else -> throw IllegalArgumentException()
    }

    override fun getItemCount() = items.size
}