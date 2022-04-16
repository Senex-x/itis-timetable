package com.senex.timetable.domain.model.subject

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
    enum class Type {
        LECTURE,
        SEMINAR,
        UNDEFINED,
    }

    enum class Kind {
        ORDINARY,
        PHYSICAL,
        ENGLISH,
        ELECTIVE,
        BLOCK
    }
}



