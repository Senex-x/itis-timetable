package com.senex.timetable.presentation.ui.subject.elective.selectable.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.R
import com.senex.timetable.databinding.ListItemSelectableSubjectBinding
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.presentation.common.bindListItemView
import com.senex.timetable.presentation.ui.subject.elective.selectable.recycler.SelectableElectiveSubjectsRecyclerAdapter.ViewHolder

class SelectableElectiveSubjectsRecyclerAdapter : ListAdapter<Subject, ViewHolder>(
    SubjectDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        bindListItemView(
            ListItemSelectableSubjectBinding::bind,
            parent,
            R.layout.list_item_selectable_subject
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ListItemSelectableSubjectBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Subject): Unit = with(binding) {
            electiveSubjectName.text = item.name
            fullProfessorName.text = item.fullProfessorName
            type.text = root.resources.getString(item.type.nameStringId) + ','
            roomNumber.text = item.room
        }
    }
}