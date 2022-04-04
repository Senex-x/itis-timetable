package com.senex.timetable.data.model.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.model.group.GroupEntity
import com.senex.timetable.domain.entities.group.Group

data class ScheduleEntity(
    @Embedded
    val scheduleInfoEntity: ScheduleInfoEntity,
    @Relation(
        parentColumn = "group_id",
        entityColumn = "id",
    )
    val groupEntity: GroupEntity,
    @Relation(
        entity = DailyScheduleInfoEntity::class,
        parentColumn = "id",
        entityColumn = "schedule_id",
    )
    val dailyScheduleEntities: List<DailyScheduleEntity>,
)