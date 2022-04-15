package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.EnglishSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.EnglishSubject
import com.senex.timetable.domain.repository.local.EnglishSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EnglishSubjectRepositoryImpl @Inject constructor(
    private val englishSubjectDao: EnglishSubjectDao,
) : EnglishSubjectRepository {

    override suspend fun insert(item: EnglishSubject) =
        englishSubjectDao.insert(item.transform())

    override suspend fun insertAll(vararg items: EnglishSubject) =
        englishSubjectDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: EnglishSubject) =
        englishSubjectDao.update(item.transform())

    override suspend fun delete(item: EnglishSubject) =
        englishSubjectDao.delete(item.transform())

    override fun get(id: Long) =
        englishSubjectDao.get(id).map { it?.transform() }

    override fun getAll() =
        englishSubjectDao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        englishSubjectDao.deleteById(id)

    override suspend fun deleteAll() =
        englishSubjectDao.deleteAll()
}
