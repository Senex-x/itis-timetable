package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class DeleteAllGroups @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    suspend operator fun invoke() = groupRepository.deleteAll()
}