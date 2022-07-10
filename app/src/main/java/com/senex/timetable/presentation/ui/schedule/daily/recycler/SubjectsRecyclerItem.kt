package com.senex.timetable.presentation.ui.schedule.daily.recycler

import android.annotation.SuppressLint
import android.view.View
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.senex.timetable.R
import com.senex.timetable.databinding.*
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.util.log
import com.senex.timetable.presentation.common.DelegateInflater

sealed class SubjectsRecyclerItem {

    data class OrdinaryItem(
        val subject: Subject,
    ) : SubjectsRecyclerItem() {
        companion object {
            @SuppressLint("SetTextI18n")
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<OrdinaryItem, SubjectsRecyclerItem, ListItemOrdinarySubjectBinding>(
                    DelegateInflater(ListItemOrdinarySubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.subject.id)
                    }

                    bind {
                        with(binding) {
                            val item = item.subject

                            timePeriod.startTime.text = item.startTime
                            timePeriod.endTime.text = item.endTime

                            if (item.isVisible) {
                                subjectInfo.name.text = item.name
                                subjectInfo.type.text = root.resources.getString(item.type.nameStringId) +
                                        if(item.room.isNotBlank()) "," else ""
                                subjectInfo.roomNumber.text = item.room
                            }
                        }
                    }
                }
        }
    }

    data class ElectiveItem(
        val electiveSubjectId: Long,
        val isVisible: Boolean,
        val indexInDay: Int,
        val primarySubject: Subject?,
        val timePeriod: Pair<String, String>,
    ) : SubjectsRecyclerItem() {
        companion object {
            @SuppressLint("SetTextI18n")
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<ElectiveItem, SubjectsRecyclerItem, ListItemVariedSubjectBinding>(
                    DelegateInflater(ListItemVariedSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.electiveSubjectId)
                    }

                    bind {
                        with(binding) {
                            timePeriod.startTime.text = item.timePeriod.first
                            timePeriod.endTime.text = item.timePeriod.second

                            val primarySubject = item.primarySubject
                            when {
                                !item.isVisible -> {
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.GONE
                                }
                                primarySubject == null -> { // Not selected yet
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.VISIBLE

                                    unselectedSubjectHint.text = getString(
                                        R.string.elective_course_not_selected_hint
                                    )
                                    root.setBackgroundColor(
                                        root.resources.getColor(
                                            R.color.color_background_floating, root.context.theme
                                        )
                                    )
                                }
                                else -> { // Has primary and visible
                                    primarySubjectContent.visibility = View.VISIBLE
                                    unselectedSubjectContent.visibility = View.GONE

                                    subjectInfo.name.text = primarySubject.name
                                    subjectInfo.roomNumber.text = primarySubject.room
                                    subjectInfo.type.text = getString(
                                        primarySubject.type.nameStringId
                                    ) + if (primarySubject.room.isNotBlank()) "," else ""
                                }
                            }
                        }
                    }
                }
        }
    }

    data class EnglishItem(
        val englishSubjectId: Long,
        val isVisible: Boolean,
        val indexInDay: Int,
        val primarySubject: Subject?,
        val timePeriod: Pair<String, String>,
    ) : SubjectsRecyclerItem() {
        companion object {
            @SuppressLint("SetTextI18n")
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<EnglishItem, SubjectsRecyclerItem, ListItemVariedSubjectBinding>(
                    DelegateInflater(ListItemVariedSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.englishSubjectId)
                    }

                    bind {
                        with(binding) {
                            timePeriod.startTime.text = item.timePeriod.first
                            timePeriod.endTime.text = item.timePeriod.second

                            val primarySubject = item.primarySubject
                            when {
                                !item.isVisible -> { // Treat like empty subject
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.GONE
                                }
                                primarySubject == null -> { // Not selected yet
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.VISIBLE

                                    unselectedSubjectHint.text = getString(
                                        R.string.english_group_not_selected_hint
                                    )
                                    root.setBackgroundColor(
                                        root.resources.getColor(
                                            R.color.color_background_floating, root.context.theme
                                        )
                                    )
                                }
                                else -> { // Has primary and selected
                                    primarySubjectContent.visibility = View.VISIBLE
                                    unselectedSubjectContent.visibility = View.GONE

                                    subjectInfo.name.text = primarySubject.name
                                    subjectInfo.roomNumber.text = primarySubject.room
                                    subjectInfo.type.text = getString(
                                        primarySubject.type.nameStringId
                                    ) + if (primarySubject.room.isNotBlank()) "," else ""
                                }
                            }
                        }
                    }
                }
        }
    }

    data class PhysicalItem(
        val physicalSubject: Subject,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<PhysicalItem, SubjectsRecyclerItem, ListItemPhysicalSubjectBinding>(
                    DelegateInflater(ListItemPhysicalSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.physicalSubject.id)
                    }

                    bind {
                        with(binding) {
                            val item = item.physicalSubject

                            timePeriod.startTime.text = item.startTime
                            timePeriod.endTime.text = item.endTime

                            if (item.isVisible) {
                                subjectName.text = item.name
                            }
                        }
                    }
                }
        }
    }

    data class BlockItem(
        val blockSubject: Subject,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<BlockItem, SubjectsRecyclerItem, ListItemBlockSubjectBinding>(
                    DelegateInflater(ListItemBlockSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.blockSubject.id)
                    }

                    bind {
                        with(binding) {
                            val item = item.blockSubject

                            timePeriod.startTime.text = item.startTime
                            timePeriod.endTime.text = item.endTime

                            if (item.isVisible) {
                                blockSubjectName.text = item.name
                            }
                        }
                    }
                }
        }
    }

    data class EmptyItem(
        val emptySubject: Subject,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate() =
                adapterDelegateViewBinding<EmptyItem, SubjectsRecyclerItem, ListItemEmptySubjectBinding>(
                    DelegateInflater(ListItemEmptySubjectBinding::inflate)::inflate
                ) {
                    bind {
                        with(binding) {
                            val item = item.emptySubject

                            timePeriod.startTime.text = item.startTime
                            timePeriod.endTime.text = item.endTime
                        }
                    }
                }
        }
    }
}