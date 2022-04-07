package com.senex.timetable.domain.repository.remote

import com.senex.timetable.domain.model.schedule.Schedule
import kotlinx.coroutines.flow.Flow

interface ScheduleRemoteRepository {
    fun getSchedule(groupId: Long): Flow<Schedule?>

    fun getSchedule(groupName: String): Flow<Schedule?>
}