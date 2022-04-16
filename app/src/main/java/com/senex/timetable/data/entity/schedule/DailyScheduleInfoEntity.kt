package com.senex.timetable.data.entity.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(
    tableName = "daily_schedules",
    foreignKeys = [
        ForeignKey(
            entity = ScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["schedule_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class DailyScheduleInfoEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "schedule_id")
    val scheduleId: Long,
    val dayName: String,
    @ColumnInfo(name = "index_in_week")
    val indexInWeek: Int,
)
