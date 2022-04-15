package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class DeleteGroupById @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    suspend operator fun invoke(groupId: Long) = groupRepository.deleteById(groupId)
}