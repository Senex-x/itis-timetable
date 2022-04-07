package com.senex.timetable.data.api

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleService : ScheduleRemoteRepository {

    @GET("/schedule/{groupId}")
    override fun getSchedule(@Path("groupId") groupId: Long): Flow<Schedule?>

    @GET("/schedule/{groupName}")
    override fun getSchedule(@Path("groupName") groupName: String): Flow<Schedule?>
}