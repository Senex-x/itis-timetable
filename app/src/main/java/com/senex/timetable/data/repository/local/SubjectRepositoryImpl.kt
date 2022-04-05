package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.SubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SubjectRepositoryImpl @Inject constructor(
    private val subjectDao: SubjectDao,
) : SubjectRepository {

    override suspend fun insert(item: Subject) =
        subjectDao.insert(item.transform())

    override suspend fun insertAll(vararg items: Subject) =
        subjectDao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: Subject) =
        subjectDao.update(item.transform())

    override suspend fun delete(item: Subject) =
        subjectDao.delete(item.transform())

    override fun get(id: Long) =
        subjectDao.get(id).map { it?.transform() }

    override fun getAll() =
        subjectDao.getAll().map { list -> list.map { it.transform() } }

    override fun getAll(groupId: Long, dayIndexInWeek: Int) =
        subjectDao.getAll(groupId, dayIndexInWeek).map { list -> list.map { it.transform() } }

    override fun getAllExcludingHidden(groupId: Long, dayIndexInWeek: Int) =
        subjectDao.getAllExcludingHidden(groupId, dayIndexInWeek).map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        subjectDao.delete(id)

    override suspend fun deleteAll() =
        subjectDao.deleteAll()
}