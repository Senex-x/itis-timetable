package com.senex.timetable.domain.model.schedule

import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.model.subject.VariedSubject

data class DailySchedule(
    val dailyScheduleInfo: DailyScheduleInfo,
    val variedSubjectEntities: List<VariedSubject>,
    val englishSubjectEntities: List<EnglishSubject>,
    val subjects: List<Subject>,
)
