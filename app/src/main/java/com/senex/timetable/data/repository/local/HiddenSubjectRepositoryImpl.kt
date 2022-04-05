package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.HiddenSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.HiddenSubject
import com.senex.timetable.domain.repository.HiddenSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HiddenSubjectRepositoryImpl @Inject constructor(
    private val hiddenSubjectDao: HiddenSubjectDao,
) : HiddenSubjectRepository {

    override suspend fun insert(item: HiddenSubject) =
        hiddenSubjectDao.insert(item.transform())

    override suspend fun insertAll(vararg items: HiddenSubject) =
        hiddenSubjectDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: HiddenSubject) =
        hiddenSubjectDao.update(item.transform())

    override suspend fun delete(item: HiddenSubject) =
        hiddenSubjectDao.delete(item.transform())

    override fun get(id: Long) =
        hiddenSubjectDao.get(id).map { it?.transform() }

    override fun getAll() =
        hiddenSubjectDao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        hiddenSubjectDao.delete(id)

    override suspend fun deleteAll() =
        hiddenSubjectDao.deleteAll()
}
