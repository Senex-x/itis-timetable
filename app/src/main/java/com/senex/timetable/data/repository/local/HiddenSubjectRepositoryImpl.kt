package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.HiddenSubjectDao
import com.senex.timetable.domain.repository.HiddenSubjectRepository
import javax.inject.Inject

class HiddenSubjectRepositoryImpl @Inject constructor(
    database: AppDatabase,
) : HiddenSubjectRepository, HiddenSubjectDao by database.hiddenSubjectDao()
