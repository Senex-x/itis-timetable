package com.senex.timetable.presentation.ui.schedule.daily.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.databinding.ListItemOrdinarySubjectBinding
import com.senex.timetable.domain.model.subject.Subject

class SubjectRecyclerAdapter : ListAdapter<Subject, SubjectRecyclerAdapter.SubjectViewHolder>(
    SubjectDiffCallback
) {
    var onItemClickListener: ((Long) -> Unit)? = null

    inner class SubjectViewHolder(
        private val binding: ListItemOrdinarySubjectBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Subject): Unit = with(binding) {
            period.text = item.startTime +
                    "\n" + item.endTime
            name.text = item.name
            type.text = item.type.name
            roomNumber.text = item.room
            id.text = item.id.toString()

            root.setOnClickListener {
                onItemClickListener?.invoke(item.id)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = SubjectViewHolder(
        ListItemOrdinarySubjectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(
        holder: SubjectRecyclerAdapter.SubjectViewHolder,
        position: Int,
    ) = holder.bind(getItem(position))
}