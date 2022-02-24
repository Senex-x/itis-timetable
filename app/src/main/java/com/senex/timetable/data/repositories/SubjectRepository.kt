package com.senex.timetable.data.repositories

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.SubjectDao
import javax.inject.Inject

class SubjectRepository @Inject constructor(
    database: AppDatabase,
) : SubjectDao by database.subjectDao()