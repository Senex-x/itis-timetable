package com.senex.timetable.data.entity.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.entity.group.GroupEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
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