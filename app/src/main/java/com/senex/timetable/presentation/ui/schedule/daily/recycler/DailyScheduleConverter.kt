package com.senex.timetable.presentation.ui.schedule.daily.recycler

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.usecase.subject.english.hidden.IsEnglishSubjectHidden
import com.senex.timetable.domain.usecase.subject.english.primary.GetPrimarySubjectByEnglishSubjectId
import kotlinx.coroutines.flow.first

/**
 * Maps daily subjects.
 * Works properly only if the list items are sorted by indexInDay property.
 */
suspend fun DailySchedule.toSubjectsRecyclerItems(
    getPrimarySubjectByEnglishSubjectId: GetPrimarySubjectByEnglishSubjectId,
    isEnglishSubjectHidden: IsEnglishSubjectHidden,
) = buildList {
    val dailySchedule = this@toSubjectsRecyclerItems
    val subjects = dailySchedule.subjects

    var lastElectiveSubjectId = -1L
    var lastEnglishSubjectId = -1L
    var electiveSubjects = mutableListOf<Subject>()
    var englishSubjects = mutableListOf<Subject>()

    suspend fun flushSubjectLists() { // Always call before changing id variables
        if (electiveSubjects.isNotEmpty()) {
            val electiveSubject = dailySchedule.electiveSubjects.find {
                it.id == lastElectiveSubjectId
            }!!

            add(SubjectsRecyclerItem.ElectiveItem(
                lastElectiveSubjectId,
                electiveSubject.isVisible,
                electiveSubjects.find { it.id == electiveSubject.primarySubjectId },
                electiveSubjects,
            ))
            electiveSubjects = mutableListOf()
        }
        if (englishSubjects.isNotEmpty()) {
            add(SubjectsRecyclerItem.EnglishItem(
                lastEnglishSubjectId,
                isEnglishSubjectHidden(lastEnglishSubjectId),
                getPrimarySubjectByEnglishSubjectId(lastEnglishSubjectId).first(),
                englishSubjects,
            ))
            englishSubjects = mutableListOf()
        }
    }

    for (subject in subjects) {
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