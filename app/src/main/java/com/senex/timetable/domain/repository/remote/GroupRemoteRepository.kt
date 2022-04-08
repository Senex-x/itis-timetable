package com.senex.timetable.domain.repository.remote

import com.senex.timetable.domain.model.group.Group

interface GroupRemoteRepository {
    suspend fun getAll(): List<Group>?
}