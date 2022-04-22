package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(
    tableName = "subjects",
    foreignKeys = [
        ForeignKey(
            entity = DailyScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["daily_schedule_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = ElectiveSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["elective_subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = EnglishSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["english_subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
@JsonClass(generateAdapter = true)
data class SubjectEntity constructor(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
    @ColumnInfo(name = "elective_subject_id")
    val electiveSubjectId: Long?,
    @ColumnInfo(name = "english_subject_id")
    val englishSubjectId: Long?,
    @Json(ignore = true)
    @ColumnInfo(name = "is_visible")
    val isVisible: Boolean = true,
    @ColumnInfo(name = "number_in_day")
    val indexInDay: Int,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    val name: String,
    val room: String,
    val type: Type,
    val kind: Kind,
    @ColumnInfo(name = "teacher_name")
    val teacherName: String,
    @ColumnInfo(name = "teacher_surname")
    val teacherSurname: String,
    @ColumnInfo(name = "teacher_patronymic")
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
        BLOCK,
        EMPTY,
    }
}


