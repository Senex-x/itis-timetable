package com.senex.timetable.data.models.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.models.subject.Subject

data class DailySchedule(
    @Embedded
    val dailyScheduleEntity: DailyScheduleEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjects: List<Subject>,
)
