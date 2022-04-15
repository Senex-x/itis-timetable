package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.PrimaryElectiveSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.PrimaryElectiveSubject
import com.senex.timetable.domain.repository.local.PrimaryElectiveSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrimaryElectiveSubjectRepositoryImpl @Inject constructor(
    private val dao: PrimaryElectiveSubjectDao,
) : PrimaryElectiveSubjectRepository {

    override suspend fun insert(item: PrimaryElectiveSubject) =
        dao.insert(item.transform())

    override suspend fun insertAll(vararg items: PrimaryElectiveSubject) =
        dao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: PrimaryElectiveSubject) =
        dao.update(item.transform())

    override suspend fun delete(item: PrimaryElectiveSubject) =
        dao.delete(item.transform())

    override fun get(id: Long) =
        dao.get(id).map { it?.transform() }

    override fun getByElectiveSubjectId(electiveSubjectId: Long) =
        dao.getByElectiveSubjectId(electiveSubjectId).map { it?.transform() }

    override fun getAll() =
        dao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        dao.deleteById(id)

    override suspend fun deleteAll() =
        dao.deleteAll()
}
