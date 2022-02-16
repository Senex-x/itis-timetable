package com.senex.timetable.data.models.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_schedules")
data class DailyScheduleEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "schedule_id")
    val scheduleId: Long,
    val name: String,
    @ColumnInfo(name = "number_in_week")
    val numberInWeek: Int,
)
