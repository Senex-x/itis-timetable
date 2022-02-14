package com.senex.timetable.presentation.fragments.schedule.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.ScheduleDayListItemBinding
import com.senex.timetable.databinding.ScheduleListItemBinding
import com.senex.timetable.presentation.fragments.schedule.recycler.items.DayItem
import com.senex.timetable.presentation.fragments.schedule.recycler.items.ScheduleListItem
import com.senex.timetable.presentation.fragments.schedule.recycler.items.ScheduleListItemType
import com.senex.timetable.presentation.fragments.schedule.recycler.items.SubjectItem

class ScheduleRecyclerAdapter(
    private val items: List<ScheduleListItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class DayViewHolder(
        private val binding: ScheduleDayListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ScheduleListItem): Unit = with(binding) {
            val dayItem = item as DayItem

            name.text = dayItem.name
        }
    }

    inner class SubjectViewHolder(
        private val binding: ScheduleListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: ScheduleListItem): Unit = with(binding) {
            val subjectItem = item as SubjectItem

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
        ScheduleListItemType.Day.value ->
            DayViewHolder(
                ScheduleDayListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))

        ScheduleListItemType.Subject.value ->
            SubjectViewHolder(
                ScheduleListItemBinding.inflate(
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
        ScheduleListItemType.Day.value ->
            (holder as DayViewHolder)
                .bind(items[position])

        ScheduleListItemType.Subject.value ->
            (holder as SubjectViewHolder)
                .bind(items[position])

        else -> throw IllegalArgumentException()
    }

    override fun getItemCount() = items.size
}