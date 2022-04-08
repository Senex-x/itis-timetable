package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.remote.ScheduleRemoteRepository
import javax.inject.Inject

class SyncScheduleByGroupId @Inject constructor(
    private val scheduleRemoteRepository: ScheduleRemoteRepository,
    private val saveSchedule: SaveSchedule,
    private val deleteGroupById: DeleteGroupById,
) {
    suspend operator fun invoke(groupId: Long) {
        scheduleRemoteRepository.getByGroupId(groupId)?.let {
            deleteGroupById(groupId)
            saveSchedule(it)
        }
    }
}