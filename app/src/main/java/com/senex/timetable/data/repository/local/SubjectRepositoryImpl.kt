package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.SubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.repository.local.SubjectRepository
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
        subjectDao.getAll(groupId, dayIndexInWeek).map { list ->
            list.map { it.transform() }
        }

    override fun getAllVisible(groupId: Long, dayIndexInWeek: Int) =
        subjectDao.getAllVisible(groupId, dayIndexInWeek).map { list ->
            list.map { it.transform() }
        }

    override suspend fun deleteById(id: Long) =
        subjectDao.deleteById(id)

    override suspend fun deleteAll() =
        subjectDao.deleteAll()

    override suspend fun show(id: Long) =
        subjectDao.show(id)

    override suspend fun hide(id: Long) =
        subjectDao.hide(id)

    override fun getAllByElectiveSubjectId(electiveSubjectId: Long) =
        subjectDao.getAllByElectiveSubjectId(electiveSubjectId).map { list ->
            list.map { it.transform() }
        }

    override fun getAllByEnglishSubjectId(englishSubjectId: Long) =
        subjectDao.getAllByEnglishSubjectId(englishSubjectId).map { list ->
            list.map { it.transform() }
        }

    override suspend fun setPeriodicity(periodicity: Subject.Periodicity, id: Long) =
        subjectDao.setPeriodicity(periodicity, id)

    override suspend fun setIsRemote(isRemote: Boolean, id: Long) =
        subjectDao.setIsRemote(isRemote, id)
}
