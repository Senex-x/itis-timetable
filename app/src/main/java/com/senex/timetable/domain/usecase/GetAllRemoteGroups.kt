package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.repository.remote.GroupRemoteRepository
import javax.inject.Inject

class GetAllRemoteGroups @Inject constructor(
    private val groupRemoteRepository: GroupRemoteRepository,
) {
    suspend operator fun invoke() =  groupRemoteRepository.getAll()
}