package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "primary_subjects",
    foreignKeys = [
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)
data class PrimarySubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "subject_id")
    val subjectId: Long
)