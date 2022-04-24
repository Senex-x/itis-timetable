package com.senex.timetable.presentation.ui.schedule.daily.recycler

import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.util.log


/**
 * Maps daily subjects.
 * Works properly only if the list items are sorted by indexInDay property.
 */
fun DailySchedule.toSubjectsRecyclerItems() = buildList {
    val dailySchedule = this@toSubjectsRecyclerItems
    val subjects = dailySchedule.subjects

    var lastElectiveSubjectId = -1L
    var lastEnglishSubjectId = -1L
    var electiveSubjects = mutableListOf<Subject>()
    var englishSubjects = mutableListOf<Subject>()

    fun flushSubjectLists() { // Always call before changing id variables
        if (electiveSubjects.isNotEmpty()) {
            val electiveSubject = dailySchedule.electiveSubjects.find {
                it.id == lastElectiveSubjectId
            }!!

            val firstElectiveSubject = electiveSubjects.first()
            add(SubjectsRecyclerItem.ElectiveItem(
                lastElectiveSubjectId,
                electiveSubject.isVisible,
                firstElectiveSubject.indexInDay,
                electiveSubjects.find { it.id == electiveSubject.primarySubjectId },
                firstElectiveSubject.startTime to firstElectiveSubject.endTime,
            ))
            electiveSubjects = mutableListOf()
        }
        if (englishSubjects.isNotEmpty()) {
            val englishSubject = dailySchedule.englishSubjects.find {
                it.id == lastEnglishSubjectId
            }!!

            val firstEnglishSubject = englishSubjects.first()
            add(SubjectsRecyclerItem.EnglishItem(
                lastEnglishSubjectId,
                englishSubject.isVisible,
                firstEnglishSubject.indexInDay,
                englishSubjects.find { it.id == englishSubject.primarySubjectId },
                firstEnglishSubject.startTime to firstEnglishSubject.endTime,
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
            Subject.Kind.EMPTY -> {
                flushSubjectLists()
                add(SubjectsRecyclerItem.EmptyItem(subject))
            }
        }
    }
    flushSubjectLists()
}.dropLastEmptySubjects()

private fun List<SubjectsRecyclerItem>.dropLastEmptySubjects(): List<SubjectsRecyclerItem> { // 1, 1, 1, 0, 0 -> 0, 0, 1, 1, 1
    var reversedIndexOfFirstMeaningfulSubject = 0
    run outer@{
        asReversed().forEachIndexed { index, subjectsRecyclerItem ->
            reversedIndexOfFirstMeaningfulSubject = index
            when (subjectsRecyclerItem) {
                !is SubjectsRecyclerItem.EmptyItem -> {
                    return@outer
                }
                else -> {}
            }
            log(reversedIndexOfFirstMeaningfulSubject.toString())
        }
    }
    return dropLast(reversedIndexOfFirstMeaningfulSubject)
}