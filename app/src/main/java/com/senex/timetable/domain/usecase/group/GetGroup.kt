package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class GetGroup @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    operator fun invoke(id: Long) = groupRepository.get(id)
}