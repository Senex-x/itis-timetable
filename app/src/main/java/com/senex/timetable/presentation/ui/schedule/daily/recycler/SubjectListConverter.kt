package com.senex.timetable.presentation.ui.schedule.daily.recycler

import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.util.log

/**
 * Maps daily subjects.
 * Works properly only if the list items are sorted by indexInDay property.
 */
fun List<Subject>.toSubjectsRecyclerItemList() = buildList {
    var lastElectiveSubjectId = -1L
    var lastEnglishSubjectId = -1L
    var electiveSubjects = mutableListOf<Subject>()
    var englishSubjects = mutableListOf<Subject>()

    fun flushSubjectLists() { // Always call before changing id variables
        if (electiveSubjects.isNotEmpty()) {
            add(SubjectsRecyclerItem.ElectiveItem(
                lastElectiveSubjectId,
                null,
                electiveSubjects,
            ))
            log("$lastElectiveSubjectId == ${electiveSubjects.first().electiveSubjectId}")
            electiveSubjects = mutableListOf()
        }
        if (englishSubjects.isNotEmpty()) {
            add(SubjectsRecyclerItem.EnglishItem(
                lastEnglishSubjectId,
                englishSubjects
            ))
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
                if (lastElectiveSubjectId != subject.electiveSubjectId) {
                    flushSubjectLists()
                    lastElectiveSubjectId = subject.electiveSubjectId!! // Not gonna be null
                }
                electiveSubjects.add(subject)
            }
            Subject.Kind.ENGLISH -> {
                if (lastEnglishSubjectId != subject.englishSubjectId) {
                    flushSubjectLists()
                    lastEnglishSubjectId = subject.englishSubjectId!! // Not gonna be null
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

