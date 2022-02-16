package com.senex.timetable.data.models.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.models.group.Group

data class Schedule(
    @Embedded
    val schedule: ScheduleEntity,
    @Relation(
        parentColumn = "group_id",
        entityColumn = "id",
    )
    val group: Group,
    @Relation(
        entity = DailyScheduleEntity::class,
        parentColumn = "id",
        entityColumn = "schedule_id",
    )
    val dailySchedules: List<DailySchedule>,
)