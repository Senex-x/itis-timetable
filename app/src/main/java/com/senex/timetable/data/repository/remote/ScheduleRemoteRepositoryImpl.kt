package com.senex.timetable.data.repository.remote

import com.senex.timetable.data.api.ScheduleService
import com.senex.timetable.data.entity.schedule.ScheduleEntity
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import com.senex.timetable.domain.util.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ScheduleRemoteRepositoryImpl @Inject constructor(
    private val scheduleService: ScheduleService,
) : ScheduleRemoteRepository {

    override suspend fun getSchedule(groupId: Long): Schedule? = suspendCoroutine {
        scheduleService.getSchedule(groupId).enqueue(callback(it))
    }

    override suspend fun getSchedule(groupName: String): Schedule? = suspendCoroutine {
        scheduleService.getSchedule(groupName).enqueue(callback(it))
    }

    private fun callback(continuation: Continuation<Schedule?>) = object : Callback<ScheduleEntity> {
        override fun onResponse(
            call: Call<ScheduleEntity>,
            response: Response<ScheduleEntity>,
        ) {
            continuation.resume(response.body()!!.transform())
        }

        override fun onFailure(call: Call<ScheduleEntity>, t: Throwable) {
            continuation.resume(null)
        }
    }
}