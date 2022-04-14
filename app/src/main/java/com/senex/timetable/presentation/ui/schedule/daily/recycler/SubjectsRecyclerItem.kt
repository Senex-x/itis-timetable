package com.senex.timetable.presentation.ui.schedule.daily.recycler

import com.senex.timetable.domain.model.subject.Subject

sealed class SubjectsRecyclerItem {

    data class OrdinaryItem(
        val subject: Subject,
    ) : SubjectsRecyclerItem() {

    }

    data class ElectiveItem(
        val electiveSubjects: List<Subject>,
    ) : SubjectsRecyclerItem() {

    }

    data class EnglishItem(
        val englishSubjects: List<Subject>,
    ) : SubjectsRecyclerItem() {

    }

    data class PhysicalItem(
        val physicalSubject: Subject,
    ) : SubjectsRecyclerItem() {

    }

    data class BlockItem(
        val blockSubject: Subject,
    ) : SubjectsRecyclerItem() {

    }
}