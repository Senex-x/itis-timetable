package com.senex.timetable.data.model.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.domain.entities.subject.Subject
import com.senex.timetable.domain.entities.schedule.DailyScheduleEntity

data class DailySchedule(
    @Embedded
    val dailyScheduleEntity: DailyScheduleEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjects: List<Subject>,
)
