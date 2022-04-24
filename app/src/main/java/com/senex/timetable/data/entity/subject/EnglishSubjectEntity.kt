package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(
    tableName = "english_subjects",
    foreignKeys = [
        ForeignKey(
            entity = DailyScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["daily_schedule_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["primary_subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
data class EnglishSubjectEntity(
    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,

    @Json(ignore = true)
    @ColumnInfo(name = "primary_subject_id")
    val primarySubjectId: Long? = null,

    @Json(ignore = true)
    @ColumnInfo(name = "is_visible")
    val isVisible: Boolean = true,
)