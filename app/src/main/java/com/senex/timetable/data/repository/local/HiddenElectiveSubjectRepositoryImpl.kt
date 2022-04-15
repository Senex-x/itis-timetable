package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.HiddenElectiveSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.HiddenElectiveSubject
import com.senex.timetable.domain.repository.local.HiddenElectiveSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HiddenElectiveSubjectRepositoryImpl @Inject constructor(
    private val dao: HiddenElectiveSubjectDao,
) : HiddenElectiveSubjectRepository {

    override suspend fun insert(item: HiddenElectiveSubject) =
        dao.insert(item.transform())

    override suspend fun insertAll(vararg items: HiddenElectiveSubject) =
        dao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: HiddenElectiveSubject) =
        dao.update(item.transform())

    override suspend fun delete(item: HiddenElectiveSubject) =
        dao.delete(item.transform())

    override fun get(id: Long) =
        dao.get(id).map { it?.transform() }

    override fun getAll() =
        dao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        dao.deleteById(id)

    override suspend fun deleteAll() =
        dao.deleteAll()
}
