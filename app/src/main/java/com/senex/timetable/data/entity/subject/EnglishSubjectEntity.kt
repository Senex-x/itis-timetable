package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity

@Entity(
    tableName = "english_subjects",
    foreignKeys = [
        ForeignKey(
            entity = DailyScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["daily_schedule_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class EnglishSubjectEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
)