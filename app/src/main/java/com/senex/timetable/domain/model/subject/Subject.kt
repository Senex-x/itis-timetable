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
        LECTURE(R.string.lecture_subject_type),
        SEMINAR(R.string.seminar_subject_type),
        UNDEFINED(R.string.very_meaningful_message),
    }

    enum class Kind(@StringRes val nameStringId: Int) {
        ORDINARY(R.string.ordinary_subject_kind),
        PHYSICAL(R.string.physical_subject_kind),
        ENGLISH(R.string.english_subject_kind),
        ELECTIVE(R.string.elective_subject_kind),
        BLOCK(R.string.block_subject_kind),
        EMPTY(R.string.very_meaningful_message),
    }
}



