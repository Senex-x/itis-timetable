package com.senex.timetable.domain.model.schedule

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.model.subject.ElectiveSubject

data class DailySchedule(
    val dailyScheduleInfo: DailyScheduleInfo,
    val electiveSubjects: List<ElectiveSubject>,
    val englishSubjects: List<EnglishSubject>,
    val subjects: List<Subject>,
)
