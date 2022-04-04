package com.senex.timetable.data.model.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.domain.entities.group.Group

@Entity(
    tableName = "schedules",
    foreignKeys = [
        ForeignKey(
            entity = Group::class,
            parentColumns = ["id"],
            childColumns = ["group_id"]
        )
    ],
)
data class ScheduleEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
)

