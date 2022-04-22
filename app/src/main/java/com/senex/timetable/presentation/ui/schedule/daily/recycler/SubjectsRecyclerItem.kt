package com.senex.timetable.presentation.ui.schedule.daily.recycler

import android.annotation.SuppressLint
import android.view.View
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.senex.timetable.databinding.*
import com.senex.timetable.domain.model.subject.Subject
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
                            subjectName.text = item.name
                            type.text = root.resources.getString(item.type.nameStringId) + ','
                            roomNumber.text = item.room
                        }
                    }
                }
        }
    }

    data class ElectiveItem(
        val electiveSubjectId: Long,
        val isVisible: Boolean,
        val primarySubject: Subject?,
        val timePeriod: Pair<String, String>,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<ElectiveItem, SubjectsRecyclerItem, ListItemElectiveSubjectBinding>(
                    DelegateInflater(ListItemElectiveSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.electiveSubjectId)
                    }

                    bind {
                        with(binding) {
                            val primarySubject = item.primarySubject
                            timePeriod.startTime.text = item.timePeriod.first
                            timePeriod.endTime.text = item.timePeriod.second

                            when {
                                !item.isVisible -> { // TODO: Treat like empty subject
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.GONE
                                }
                                primarySubject == null -> { // Not selected yet
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.VISIBLE
                                }
                                else -> { // Has primary and visible
                                    primarySubjectContent.visibility = View.VISIBLE
                                    unselectedSubjectContent.visibility = View.GONE

                                    primarySubjectName.text = primarySubject.name
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
        val primarySubject: Subject?,
        val englishSubjects: List<Subject>,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<EnglishItem, SubjectsRecyclerItem, ListItemEnglishSubjectBinding>(
                    DelegateInflater(ListItemEnglishSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.englishSubjects.first().id)
                    }

                    bind {
                        with(binding) {
                            val firstSubject = item.englishSubjects.first()
                            timePeriod.startTime.text = firstSubject.startTime
                            timePeriod.endTime.text = firstSubject.endTime

                            when {
                                item.isVisible -> { // Treat like empty subject
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.GONE

                                }
                                item.primarySubject == null -> { // Not selected yet
                                    primarySubjectContent.visibility = View.GONE
                                    unselectedSubjectContent.visibility = View.VISIBLE

                                }
                                else -> { // Has primary and selected
                                    primarySubjectContent.visibility = View.VISIBLE
                                    unselectedSubjectContent.visibility = View.GONE

                                    primarySubjectName.text = firstSubject.name
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
                            subjectName.text = item.name
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
                            blockSubjectName.text = item.name
                        }
                    }
                }
        }
    }
}