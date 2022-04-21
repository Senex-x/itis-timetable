package com.senex.timetable.presentation.ui.subject.elective.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.senex.timetable.R
import com.senex.timetable.databinding.ListItemSelectableElectiveSubjectBinding
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.presentation.common.bindListItemView
import com.senex.timetable.presentation.ui.subject.elective.recycler.SelectableElectiveSubjectsRecyclerAdapter.ViewHolder

class SelectableElectiveSubjectsRecyclerAdapter : ListAdapter<Subject, ViewHolder>(
    ElectiveSubjectDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        bindListItemView(
            ListItemSelectableElectiveSubjectBinding::bind,
            parent,
            R.layout.list_item_selectable_elective_subject
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ListItemSelectableElectiveSubjectBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Subject): Unit = with(binding) {
            electiveSubjectName.text = item.name
        }
    }
}