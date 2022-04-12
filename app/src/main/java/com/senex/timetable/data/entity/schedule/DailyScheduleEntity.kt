package com.senex.timetable.data.entity.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.entity.subject.SubjectEntity
import com.senex.timetable.data.entity.subject.VariedSubjectEntity

data class DailyScheduleEntity(
    @Embedded
    val dailyScheduleInfoEntity: DailyScheduleInfoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val variedSubjectEntities: List<VariedSubjectEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjectEntities: List<SubjectEntity>,
)
