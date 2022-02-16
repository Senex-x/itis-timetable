package com.senex.timetable.data.models.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedules")
data class ScheduleEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
)

