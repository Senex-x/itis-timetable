package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "hidden_english_subjects",
    foreignKeys = [
        ForeignKey(
            entity = EnglishSubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["english_subject_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class HiddenEnglishSubjectEntity(
    @PrimaryKey
    @ColumnInfo(name = "english_subject_id")
    val englishSubjectId: Long,
)