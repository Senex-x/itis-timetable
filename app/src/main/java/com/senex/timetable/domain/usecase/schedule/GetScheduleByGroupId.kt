package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.repository.local.ScheduleRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetScheduleByGroupId @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
) {
    operator fun invoke(groupId: Long) = scheduleRepository.getByGroupId(groupId)
}