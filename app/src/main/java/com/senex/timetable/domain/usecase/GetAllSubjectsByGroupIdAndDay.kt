package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.SubjectRepository
import java.time.DayOfWeek

class GetAllSubjectsByGroupIdAndDay(
    private val subjectRepository: SubjectRepository,
) {
    suspend operator fun invoke(
        groupId: Long,
        dayOfWeek: DayOfWeek,
    ) = subjectRepository.getAll(
        groupId,
        dayOfWeek.value,
    )
}