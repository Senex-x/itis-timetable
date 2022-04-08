package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import javax.inject.Inject

class SyncLocalScheduleByGroupId @Inject constructor(
    private val scheduleRemoteRepository: ScheduleRemoteRepository,
    private val saveSchedule: SaveSchedule,
    private val deleteGroupById: DeleteGroupById,
) {
    suspend operator fun invoke(groupId: Long) {
        scheduleRemoteRepository.getSchedule(groupId)?.let {
            deleteGroupById(groupId)
            saveSchedule(it)
        }
    }
}