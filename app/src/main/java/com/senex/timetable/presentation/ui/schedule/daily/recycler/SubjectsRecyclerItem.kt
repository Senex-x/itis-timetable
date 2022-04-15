package com.senex.timetable.presentation.ui.schedule.daily.recycler

import android.annotation.SuppressLint
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
                            subjectName.text = item.subject.name
                            startTime.text = item.subject.startTime
                            endTime.text = item.subject.endTime
                            type.text = item.subject.type.name
                            roomNumber.text = item.subject.room
                        }
                    }
                }
        }
    }

    data class ElectiveItem(
        val electiveSubjectId: Long,
        val primarySubject: Subject?,
        val electiveSubjects: List<Subject>,
    ) : SubjectsRecyclerItem() {
        companion object {
            fun getDelegate(onItemClick: (Long) -> Unit) =
                adapterDelegateViewBinding<ElectiveItem, SubjectsRecyclerItem, ListItemElectiveSubjectBinding>(
                    DelegateInflater(ListItemElectiveSubjectBinding::inflate)::inflate
                ) {
                    binding.root.setOnClickListener {
                        onItemClick(item.electiveSubjects.first().id)
                    }

                    bind {
                        with(binding) {
                            subjectName.text = item.electiveSubjects.first().name
                        }
                    }
                }
        }
    }

    data class EnglishItem(
        val englishSubjectId: Long,
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
                            subjectName.text = item.englishSubjects.first().name
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
                            subjectName.text = item.physicalSubject.name
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
                            subjectName.text = item.blockSubject.name
                        }
                    }
                }
        }
    }
}