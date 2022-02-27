package com.senex.timetable.data.models.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "hidden_subjects",
    foreignKeys = [
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
        )
    ]
)
data class HiddenSubject(
    @PrimaryKey
    @ColumnInfo(name = "subject_id")
    val subjectId: Long,
)
