package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.DailyScheduleDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo
import com.senex.timetable.domain.repository.local.DailyScheduleRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DailyScheduleRepositoryImpl @Inject constructor(
    private val dailyScheduleDao: DailyScheduleDao,
) : DailyScheduleRepository {

    override suspend fun deleteById(id: Long) =
        dailyScheduleDao.delete(id)

    override suspend fun insert(item: DailyScheduleInfo) =
        dailyScheduleDao.insert(item.transform())

    override suspend fun insertAll(vararg items: DailyScheduleInfo) =
        dailyScheduleDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: DailyScheduleInfo) =
        dailyScheduleDao.update(item.transform())

    override suspend fun delete(item: DailyScheduleInfo) =
        dailyScheduleDao.delete(item.transform())

    override fun get(id: Long) =
        dailyScheduleDao.get(id).map { it?.transform() }

    override fun getAll() =
        dailyScheduleDao.getAll().map { list -> list.map { it.transform() } }

    override fun getAllByGroupIdAndDayIndex(
        groupId: Long,
        dayIndexInWeek: Int,
    ) = dailyScheduleDao.getAllByGroupIdAndDayIndex(groupId, dayIndexInWeek)
        .map { list -> list.map { it.transform() } }

    override suspend fun deleteAll() =
        dailyScheduleDao.deleteAll()
}
