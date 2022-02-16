package com.senex.timetable.data.models.schedule

import androidx.room.Embedded
import androidx.room.Relation

data class Schedule(
    @Embedded
    val schedule: ScheduleEntity,
    @Relation(
        entity = DailyScheduleEntity::class,
        parentColumn = "id",
        entityColumn = "schedule_id",
    )
    val dailySchedules: List<DailySchedule>,
)