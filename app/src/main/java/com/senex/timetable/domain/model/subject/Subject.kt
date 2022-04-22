package com.senex.timetable.domain.model.subject

import androidx.annotation.StringRes
import com.senex.timetable.R

data class Subject(
    val id: Long,
    val dailyScheduleId: Long,
    val electiveSubjectId: Long?,
    val englishSubjectId: Long?,
    val isVisible: Boolean,
    val indexInDay: Int,
    val startTime: String,
    val endTime: String,
    val name: String,
    val room: String,
    val type: Type,
    val kind: Kind,
    val teacherName: String,
    val teacherSurname: String,
    val teacherPatronymic: String,
) {
    val fullProfessorName = "$teacherSurname $teacherName$teacherPatronymic"

    enum class Type(@StringRes val nameStringId: Int) {
        LECTURE(R.string.lecture_enum_name),
        SEMINAR(R.string.seminar_enum_name),
        UNDEFINED(R.string.undefined_enum_name),
    }

    enum class Kind {
        ORDINARY,
        PHYSICAL,
        ENGLISH,
        ELECTIVE,
        BLOCK
    }
}



