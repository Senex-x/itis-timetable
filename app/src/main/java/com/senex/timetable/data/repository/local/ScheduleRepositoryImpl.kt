package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.ScheduleDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.entities.schedule.ScheduleInfo
import com.senex.timetable.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleDao: ScheduleDao,
) : ScheduleRepository {

    override suspend fun insert(item: ScheduleInfo) =
        scheduleDao.insert(item.transform())

    override suspend fun insertAll(vararg items: ScheduleInfo) =
        scheduleDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: ScheduleInfo) =
        scheduleDao.update(item.transform())

    override suspend fun delete(item: ScheduleInfo) =
        scheduleDao.delete(item.transform())

    override suspend fun get(id: Long) =
        scheduleDao.get(id)?.transform()

    override suspend fun getByGroupId(groupId: Long) =
        scheduleDao.getByGroupId(groupId)?.transform()

    override suspend fun getAll() =
        scheduleDao.getAll().map { it.transform() }

    override suspend fun deleteAll() =
        scheduleDao.deleteAll()
}