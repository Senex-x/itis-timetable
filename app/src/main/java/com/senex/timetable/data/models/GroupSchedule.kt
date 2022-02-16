package com.senex.timetable.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedules")
data class GroupSchedule(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
    @ColumnInfo(name = "daily_schedules")
    val dailySchedules: List<DaySchedule>,
)

