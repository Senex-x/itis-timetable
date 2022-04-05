package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.DailyScheduleDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.schedule.DailySchedule
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo
import com.senex.timetable.domain.repository.DailyScheduleRepository
import javax.inject.Inject

class DailyScheduleRepositoryImpl @Inject constructor(
    private val dailyScheduleDao: DailyScheduleDao,
) : DailyScheduleRepository {

    override suspend fun insert(item: DailySchedule) =
        dailyScheduleDao.insert(item.transform())

    override suspend fun insertAll(vararg items: DailySchedule) =
        dailyScheduleDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: DailySchedule) =
        dailyScheduleDao.update(item.transform())

    override suspend fun delete(item: DailySchedule) =
        dailyScheduleDao.delete(item.transform())

    override suspend fun get(id: Long) =
        dailyScheduleDao.get(id)?.transform()

    override suspend fun getAll() =
        dailyScheduleDao.getAll().map { it.transform() }

    override suspend fun getAllByGroupIdAndDayIndex(
        groupId: Long,
        dayIndexInWeek: Int,
    ) = dailyScheduleDao.getAllByGroupIdAndDayIndex(groupId, dayIndexInWeek)
        .map { it.transform() }

    override suspend fun deleteAll() =
        dailyScheduleDao.deleteAll()
}
