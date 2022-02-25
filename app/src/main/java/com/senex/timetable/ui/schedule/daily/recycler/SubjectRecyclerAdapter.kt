package com.senex.timetable.ui.schedule.daily.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.databinding.ListItemSubjectBinding

class SubjectRecyclerAdapter : ListAdapter<Subject, SubjectRecyclerAdapter.SubjectViewHolder>(
    SubjectDiffCallback
) {

    inner class SubjectViewHolder(
        private val binding: ListItemSubjectBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Subject): Unit = with(binding) {
            period.text = item.startTime +
                    "\n" + item.endTime
            name.text = item.name
            type.text = item.type.name
            roomNumber.text = item.room
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = SubjectViewHolder(
        ListItemSubjectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(
        holder: SubjectRecyclerAdapter.SubjectViewHolder,
        position: Int,
    ) = holder.bind(getItem(position))
}