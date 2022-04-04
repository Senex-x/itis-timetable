package com.senex.timetable.data.mapper

import com.senex.timetable.data.model.group.GroupEntity
import com.senex.timetable.domain.entities.group.Group

internal fun GroupEntity.transform() = Group(
    id,
    name,
    courseNumber,
)

internal fun Group.transform() = GroupEntity(
    id,
    name,
    courseNumber,
)