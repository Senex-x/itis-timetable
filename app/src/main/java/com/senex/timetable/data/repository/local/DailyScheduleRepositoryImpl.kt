package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.DailyScheduleDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.entities.schedule.DailyScheduleInfo
import com.senex.timetable.domain.repository.DailyScheduleRepository
import javax.inject.Inject

class DailyScheduleRepositoryImpl @Inject constructor(
    private val dailyScheduleDao: DailyScheduleDao,
) : DailyScheduleRepository {

    override suspend fun insert(item: DailyScheduleInfo) =
        dailyScheduleDao.insert(item.transform())

    override suspend fun insertAll(vararg items: DailyScheduleInfo) =
        dailyScheduleDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: DailyScheduleInfo) =
        dailyScheduleDao.update(item.transform())

    override suspend fun delete(item: DailyScheduleInfo) =
        dailyScheduleDao.delete(item.transform())

    override suspend fun get(id: Long) =
        dailyScheduleDao.get(id)?.transform()

    override suspend fun getAll() =
        dailyScheduleDao.getAll().map { it.transform() }

    override suspend fun getAllByGroupIdAndDayNumber(
        groupId: Long,
        dayNumberInWeek: Int,
    ) = dailyScheduleDao.getAllByGroupIdAndDayNumber(groupId, dayNumberInWeek)
        .map { it.transform() }

    override suspend fun deleteAll() =
        dailyScheduleDao.deleteAll()
}
