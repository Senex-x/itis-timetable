package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.GroupDao
import com.senex.timetable.data.model.group.Group
import com.senex.timetable.domain.repository.GroupRepository
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    database: AppDatabase,
) : GroupRepository, GroupDao by database.groupDao() {

    suspend fun getAllSorted() = getAll().sortedWith(
        Comparator.comparingInt(Group::courseNumber)
    )
}