package com.senex.timetable.data.entity.subject

import androidx.room.*
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity

@Entity(
    tableName = "primary_english_subjects",
    foreignKeys = [
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = DailyScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["daily_schedule_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = EnglishSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["english_subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index("english_subject_id", unique = true)
    ],
)
data class PrimaryEnglishSubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "subject_id")
    val subjectId: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
    @ColumnInfo(name = "english_subject_id")
    val englishSubjectId: Long,
)