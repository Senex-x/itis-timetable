package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.ElectiveSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.ElectiveSubject
import com.senex.timetable.domain.repository.local.ElectiveSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ElectiveSubjectRepositoryImpl @Inject constructor(
    private val electiveSubjectDao: ElectiveSubjectDao,
) : ElectiveSubjectRepository {

    override suspend fun insert(item: ElectiveSubject) =
        electiveSubjectDao.insert(item.transform())

    override suspend fun insertAll(vararg items: ElectiveSubject) =
        electiveSubjectDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: ElectiveSubject) =
        electiveSubjectDao.update(item.transform())

    override suspend fun delete(item: ElectiveSubject) =
        electiveSubjectDao.delete(item.transform())

    override suspend fun setPrimarySubjectId(electiveSubjectId: Long, primarySubjectId: Long?) =
        electiveSubjectDao.setPrimarySubjectId(electiveSubjectId, primarySubjectId)

    override suspend fun show(id: Long) =
        electiveSubjectDao.show(id)

    override suspend fun hide(id: Long) =
        electiveSubjectDao.hide(id)

    override fun get(id: Long) =
        electiveSubjectDao.get(id).map { it?.transform() }

    override fun getAll() =
        electiveSubjectDao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        electiveSubjectDao.deleteById(id)

    override suspend fun deleteAll() =
        electiveSubjectDao.deleteAll()
}
