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
        is EmptyItem ->
            newItem is EmptyItem
                    && oldItem.emptySubject.id == newItem.emptySubject.id
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
                    && oldItem == newItem
        is EnglishItem ->
            newItem is EnglishItem
                    && oldItem == newItem
        is PhysicalItem ->
            newItem is PhysicalItem
                    && oldItem == newItem
        is BlockItem ->
            newItem is BlockItem
                    && oldItem == newItem
        is EmptyItem ->
            newItem is EmptyItem
                    && oldItem.emptySubject == newItem.emptySubject
    }
}