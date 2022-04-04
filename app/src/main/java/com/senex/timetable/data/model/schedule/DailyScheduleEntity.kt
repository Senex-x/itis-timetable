package com.senex.timetable.data.model.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.model.subject.SubjectEntity

data class DailyScheduleEntity(
    @Embedded
    val dailyScheduleInfoEntity: DailyScheduleInfoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjectEntities: List<SubjectEntity>,
)
