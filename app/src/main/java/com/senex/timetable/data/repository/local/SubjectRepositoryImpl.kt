package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.SubjectDao
import com.senex.timetable.domain.repository.SubjectRepository
import javax.inject.Inject

class SubjectRepositoryImpl @Inject constructor(
    database: AppDatabase,
) : SubjectRepository, SubjectDao by database.subjectDao()