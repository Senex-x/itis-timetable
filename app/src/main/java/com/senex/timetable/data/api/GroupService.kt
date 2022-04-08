package com.senex.timetable.data.api

import com.senex.timetable.data.entity.group.GroupEntity
import retrofit2.Call
import retrofit2.http.GET

interface GroupService {

    @GET("/group")
    fun getAllGroups(): Call<List<GroupEntity>>
}