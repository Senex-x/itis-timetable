package com.senex.timetable.data.models.schedule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "daily_schedule_id")
    val dailyScheduleId: Long,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    val name: String,
    val room: String,
    val type: SubjectType,
    @ColumnInfo(name = "is_on_even_weeks")
    val isOnEvenWeeks: Boolean,
    @ColumnInfo(name = "is_on_odd_weeks")
    val isOnOddWeeks: Boolean,
    @ColumnInfo(name = "teacher_name")
    val teacherName: String,
    @ColumnInfo(name = "teacher_surname")
    val teacherSurname: String,
    @ColumnInfo(name = "teacher_patronymic")
    val teacherPatronymic: String,
) {
    @Ignore
    val isOnEveryWeek = isOnEvenWeeks && isOnOddWeeks
}


