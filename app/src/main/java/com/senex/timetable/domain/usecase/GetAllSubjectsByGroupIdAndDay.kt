package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.SubjectRepository
import java.time.DayOfWeek
import javax.inject.Inject

class GetAllSubjectsByGroupIdAndDay @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    operator fun invoke(
        groupId: Long,
        dayOfWeek: DayOfWeek,
    ) = subjectRepository.getAll(
        groupId,
        dayIndexInWeek = dayOfWeek.value - 1,
    )
}