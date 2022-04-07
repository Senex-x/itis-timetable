package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SyncLocalScheduleByGroupId @Inject constructor(
    private val scheduleRemoteRepository: ScheduleRemoteRepository,
    private val saveSchedule: SaveSchedule,
) {
    suspend operator fun invoke(groupId: Long) {
        saveSchedule(getRemoteSchedule(groupId))
    }

    private suspend fun getRemoteSchedule(groupId: Long) =
        scheduleRemoteRepository.getSchedule(groupId).map {
            it ?: throw IllegalArgumentException("Given groupId: $groupId is invalid")
        }.first()
}