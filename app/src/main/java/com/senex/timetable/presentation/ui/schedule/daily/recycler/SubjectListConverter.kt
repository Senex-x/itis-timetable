package com.senex.timetable.presentation.ui.schedule.daily.recycler

import com.senex.timetable.domain.model.subject.Subject

/**
 * Maps daily subjects.
 * Works properly only if the list items are sorted by indexInDay property.
 */
fun List<Subject>.toSubjectsRecyclerItemList() = buildList {
    var lastElectiveSubjectId = -1L
    var lastEnglishSubjectId = -1L
    var electiveSubjects = mutableListOf<Subject>()
    var englishSubjects = mutableListOf<Subject>()

    fun flushSubjectLists() {
        if (electiveSubjects.isNotEmpty()) {
            add(SubjectsRecyclerItem.ElectiveItem(electiveSubjects))
            electiveSubjects = mutableListOf()
        }
        if (englishSubjects.isNotEmpty()) {
            add(SubjectsRecyclerItem.EnglishItem(englishSubjects))
            englishSubjects = mutableListOf()
        }
    }

    for (subject in this@toSubjectsRecyclerItemList) {
        when (subject.kind) {
            Subject.Kind.ORDINARY -> {
                flushSubjectLists()
                add(SubjectsRecyclerItem.OrdinaryItem(subject))
            }
            Subject.Kind.ELECTIVE -> {
                if(lastElectiveSubjectId != subject.electiveSubjectId) {
                    lastElectiveSubjectId = subject.electiveSubjectId!! // Not gonna be null
                    flushSubjectLists()
                }
                electiveSubjects.add(subject)
            }
            Subject.Kind.ENGLISH -> {
                if(lastEnglishSubjectId != subject.englishSubjectId) {
                    lastEnglishSubjectId = subject.englishSubjectId!! // Not gonna be null
                    flushSubjectLists()
                }
                englishSubjects.add(subject)
            }
            Subject.Kind.PHYSICAL -> {
                flushSubjectLists()
                add(SubjectsRecyclerItem.PhysicalItem(subject))
            }
            Subject.Kind.BLOCK -> {
                flushSubjectLists()
                add(SubjectsRecyclerItem.BlockItem(subject))
            }
        }
    }

    flushSubjectLists()
}

