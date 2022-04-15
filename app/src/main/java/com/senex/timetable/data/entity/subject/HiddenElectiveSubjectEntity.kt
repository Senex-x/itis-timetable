package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "hidden_elective_subjects",
    foreignKeys = [
        ForeignKey(
            entity = ElectiveSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["elective_subject_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class HiddenElectiveSubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "elective_subject_id")
    val electiveSubjectId: Long,
)