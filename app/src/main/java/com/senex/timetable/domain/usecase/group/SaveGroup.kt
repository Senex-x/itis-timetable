package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class SaveGroup @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    suspend operator fun invoke(group: Group) = groupRepository.insert(group)
}