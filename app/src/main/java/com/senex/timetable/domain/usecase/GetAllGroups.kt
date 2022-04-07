package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.GroupRepository
import javax.inject.Inject

class GetAllGroups @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    operator fun invoke() = groupRepository.getAll()
}