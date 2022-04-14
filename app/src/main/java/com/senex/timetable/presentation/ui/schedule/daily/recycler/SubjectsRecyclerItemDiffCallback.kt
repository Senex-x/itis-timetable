package com.senex.timetable.presentation.ui.schedule.daily.recycler

import androidx.recyclerview.widget.DiffUtil
import com.senex.timetable.presentation.ui.schedule.daily.recycler.SubjectsRecyclerItem.*

object SubjectsRecyclerItemDiffCallback: DiffUtil.ItemCallback<SubjectsRecyclerItem>() {
    override fun areItemsTheSame(
        oldItem: SubjectsRecyclerItem,
        newItem: SubjectsRecyclerItem,
    ) = when (oldItem) {
        is OrdinaryItem ->
            newItem is OrdinaryItem
                    && oldItem.subject.id == newItem.subject.id

        is ElectiveItem ->
            newItem is ElectiveItem
                    && oldItem.electiveSubjectId == newItem.electiveSubjectId

        is EnglishItem ->
            newItem is EnglishItem
                    && oldItem.englishSubjectId == newItem.englishSubjectId

        is PhysicalItem ->
            newItem is PhysicalItem
                    && oldItem.physicalSubject.id == newItem.physicalSubject.id

        is BlockItem ->
            newItem is BlockItem
                    && oldItem.blockSubject.id == newItem.blockSubject.id
    }

    override fun areContentsTheSame(
        oldItem: SubjectsRecyclerItem,
        newItem: SubjectsRecyclerItem,
    ) = when (oldItem) {
        is OrdinaryItem ->
            newItem is OrdinaryItem
                    && oldItem == newItem

        is ElectiveItem ->
            newItem is ElectiveItem
                    && oldItem.electiveSubjects.containsAll(newItem.electiveSubjects)
                    && newItem.electiveSubjects.containsAll(oldItem.electiveSubjects)

        is EnglishItem ->
            newItem is EnglishItem
                    && oldItem.englishSubjects.containsAll(newItem.englishSubjects)
                    && newItem.englishSubjects.containsAll(oldItem.englishSubjects)

        is PhysicalItem ->
            newItem is PhysicalItem
                    && oldItem == newItem

        is BlockItem ->
            newItem is BlockItem
                    && oldItem == newItem
    }
}