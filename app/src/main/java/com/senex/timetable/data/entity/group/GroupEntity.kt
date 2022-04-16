package com.senex.timetable.data.entity.group

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "groups")
data class GroupEntity (
    @PrimaryKey
    val id: Long,
    val name: String,
    @ColumnInfo(name = "course_number")
    val courseNumber: Int,
)
