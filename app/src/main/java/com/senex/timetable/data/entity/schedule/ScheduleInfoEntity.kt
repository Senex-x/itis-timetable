package com.senex.timetable.data.entity.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.data.entity.group.GroupEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(
    tableName = "schedules",
    foreignKeys = [
        ForeignKey(
            entity = GroupEntity::class,
            parentColumns = ["id"],
            childColumns = ["group_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class ScheduleInfoEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "group_id")
    val groupId: Long,
)

