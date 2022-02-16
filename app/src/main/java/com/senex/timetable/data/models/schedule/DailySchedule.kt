package com.senex.timetable.data.models.schedule

import androidx.room.Embedded
import androidx.room.Relation

data class DailySchedule(
    @Embedded
    val dailySchedule: DailyScheduleEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjects: List<Subject>,
)
