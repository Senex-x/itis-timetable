package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.repository.local.ScheduleRepository
import javax.inject.Inject

class IsSchedulePresent @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
) {
    suspend operator fun invoke(groupId: Long) =
        scheduleRepository.isPresent(groupId)
}