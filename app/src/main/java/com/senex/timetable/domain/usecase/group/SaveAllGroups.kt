package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.repository.local.GroupRepository
import javax.inject.Inject

class SaveAllGroups @Inject constructor(
    private val groupRepository: GroupRepository,
) {
    suspend operator fun invoke(groups: List<Group>) =
        groupRepository.insertAll(*groups.toTypedArray())
}