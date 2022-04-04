package com.senex.timetable.data.model.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.domain.entities.schedule.ScheduleEntity

@Entity(
    tableName = "daily_schedules",
    foreignKeys = [
        ForeignKey(
            entity = ScheduleEntity::class,
            parentColumns = ["id"],
            childColumns = ["schedule_id"]
        )
    ],
)
data class DailyScheduleEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "schedule_id")
    val scheduleId: Long,
    val dayName: String,
    @ColumnInfo(name = "number_in_week")
    val numberInWeek: Int,
)
