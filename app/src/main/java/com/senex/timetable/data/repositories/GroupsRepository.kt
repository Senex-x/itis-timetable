package com.senex.timetable.data.repositories

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.GroupDao
import com.senex.timetable.data.database.MainDatabase

class GroupsRepository(
    database: AppDatabase = MainDatabase(),
): GroupDao by database.groupDao() {

}