package com.senex.timetable.data.entity.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.senex.timetable.data.entity.schedule.DailyScheduleInfoEntity
import com.senex.timetable.domain.model.subject.Subject

@Entity(
    tableName = "subjects",
    foreignKeys = [
        ForeignKey(
            entity = DailyScheduleInfoEntity::class,
            parentColumns = ["id"],
            childColumns = ["daily_schedule_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
)
data class SubjectEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
    @ColumnInfo(name = "number_in_day")
    val numberInDay: Int,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    val name: String,
    val room: String,
    val type: Subject.Type,
    val kind: Subject.Kind,
    @ColumnInfo(name = "teacher_name")
    val teacherName: String,
    @ColumnInfo(name = "teacher_surname")
    val teacherSurname: String,
    @ColumnInfo(name = "teacher_patronymic")
    val teacherPatronymic: String,
) {

}


