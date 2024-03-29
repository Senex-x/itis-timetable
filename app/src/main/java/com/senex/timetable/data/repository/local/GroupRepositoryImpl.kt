package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.GroupDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.repository.local.GroupRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    private val groupDao: GroupDao,
) : GroupRepository {

    override suspend fun insert(item: Group) =
        groupDao.insert(item.transform())

    override suspend fun insertAll(vararg items: Group) =
        groupDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: Group) =
        groupDao.update(item.transform())

    override suspend fun delete(item: Group) =
        groupDao.delete(item.transform())

    override fun get(id: Long) =
        groupDao.get(id).map { it?.transform() }

    override fun getAll() =
        groupDao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        groupDao.deleteById(id)

    override suspend fun deleteAll() =
        groupDao.deleteAll()
}