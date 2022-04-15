package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class GetAllGroups @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    operator fun invoke() = groupRepository.getAll()
}