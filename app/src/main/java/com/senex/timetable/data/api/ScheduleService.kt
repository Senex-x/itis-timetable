package com.senex.timetable.data.api

import com.senex.timetable.data.entity.schedule.ScheduleEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleService {

    @GET("/schedule/{groupId}")
    suspend fun getSchedule(@Path("groupId") groupId: Long): ScheduleEntity?

    @GET("/schedule/{groupName}")
    suspend fun getSchedule(@Path("groupName") groupName: String): ScheduleEntity?
}