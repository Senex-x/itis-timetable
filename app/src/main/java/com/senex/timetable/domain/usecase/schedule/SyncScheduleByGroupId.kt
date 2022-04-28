package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.usecase.group.DeleteGroupById
import com.senex.timetable.domain.util.log
import kotlinx.coroutines.delay
import javax.inject.Inject

class SyncScheduleByGroupId @Inject constructor(
    private val getRemoteScheduleByGroupId: GetRemoteScheduleByGroupId,
    private val deleteGroupById: DeleteGroupById,
    private val saveSchedule: SaveSchedule,
) {
    suspend operator fun invoke(groupId: Long) {
        getRemoteScheduleByGroupId(groupId)?.let {
            deleteGroupById(groupId)
            saveSchedule(it)
            "Schedule sync done".log()
        }
    }
}