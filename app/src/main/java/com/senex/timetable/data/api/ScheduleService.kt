package com.senex.timetable.data.api

import com.senex.timetable.data.entity.schedule.ScheduleEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleService {

    @GET("/schedule/{groupId}")
    fun getSchedule(@Path("groupId") groupId: Long): Call<ScheduleEntity>

    @GET("/schedule/{groupName}")
    fun getSchedule(@Path("groupName") groupName: String): Call<ScheduleEntity>
}