package com.senex.timetable.data.repository.remote

import com.senex.timetable.data.api.GroupService
import com.senex.timetable.data.entity.group.GroupEntity
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.data.repository.remote.util.listContinuationCallback
import com.senex.timetable.domain.repository.remote.GroupRemoteRepository
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class GroupRemoteRepositoryImpl @Inject constructor(
    private val groupService: GroupService,
) : GroupRemoteRepository {

    override suspend fun getAll() = suspendCoroutine<List<GroupEntity>?> {
        groupService.getAllGroups().enqueue(listContinuationCallback(it))
    }?.map { it.transform() }
}