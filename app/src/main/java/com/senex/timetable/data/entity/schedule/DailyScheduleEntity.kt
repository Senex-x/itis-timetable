package com.senex.timetable.data.entity.schedule

import androidx.room.Embedded
import androidx.room.Relation
import com.senex.timetable.data.entity.subject.EnglishSubjectEntity
import com.senex.timetable.data.entity.subject.SubjectEntity
import com.senex.timetable.data.entity.subject.ElectiveSubjectEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyScheduleEntity(
    @Embedded
    val dailyScheduleInfoEntity: DailyScheduleInfoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val electiveSubjectEntities: List<ElectiveSubjectEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val englishSubjectEntities: List<EnglishSubjectEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "daily_schedule_id",
    )
    val subjectEntities: List<SubjectEntity>,
)
