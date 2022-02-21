package com.senex.timetable.data.repositories

import androidx.lifecycle.Transformations
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.GroupDao
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.models.group.Group
import javax.inject.Inject

class GroupRepository @Inject constructor(
    database: AppDatabase,
) : GroupDao by database.groupDao() {

    fun getAllSorted() = Transformations.map(getAll()) {
        it.sortedWith(
            Comparator.comparingInt(Group::courseNumber)
        )
    }
}