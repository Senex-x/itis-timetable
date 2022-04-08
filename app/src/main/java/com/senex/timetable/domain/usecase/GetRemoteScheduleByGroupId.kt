package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import javax.inject.Inject

class GetRemoteScheduleByGroupId @Inject constructor(
    private val scheduleRemoteRepository: ScheduleRemoteRepository,
) {
    suspend operator fun invoke(groupId: Long) =
        scheduleRemoteRepository.getByGroupId(groupId)
}