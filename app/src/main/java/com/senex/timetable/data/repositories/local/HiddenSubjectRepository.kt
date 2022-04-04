package com.senex.timetable.data.repositories.local

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.HiddenSubjectDao
import javax.inject.Inject

class HiddenSubjectRepository @Inject constructor(
    database: AppDatabase,
) : HiddenSubjectDao by database.hiddenSubjectDao()

