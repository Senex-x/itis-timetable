package com.senex.timetable.data.entity.subject

import androidx.room.*
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity

@Entity(
    tableName = "primary_elective_subjects",
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
            entity = ElectiveSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["elective_subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index("elective_subject_id", unique = true)
    ],
)
data class PrimaryElectiveSubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "subject_id")
    val subjectId: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
    @ColumnInfo(name = "elective_subject_id")
    val electiveSubjectId: Long,
)