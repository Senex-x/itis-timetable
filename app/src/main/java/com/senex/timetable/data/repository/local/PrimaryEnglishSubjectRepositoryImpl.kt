package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.PrimaryEnglishSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.PrimaryEnglishSubject
import com.senex.timetable.domain.repository.local.PrimaryEnglishSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PrimaryEnglishSubjectRepositoryImpl @Inject constructor(
    private val dao: PrimaryEnglishSubjectDao,
) : PrimaryEnglishSubjectRepository {

    override suspend fun insert(item: PrimaryEnglishSubject) =
        dao.insert(item.transform())

    override suspend fun insertAll(vararg items: PrimaryEnglishSubject) =
        dao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: PrimaryEnglishSubject) =
        dao.update(item.transform())

    override suspend fun delete(item: PrimaryEnglishSubject) =
        dao.delete(item.transform())

    override fun get(id: Long) =
        dao.get(id).map { it?.transform() }

    override fun getByEnglishSubjectId(englishSubjectId: Long) =
        dao.getByEnglishSubjectId(englishSubjectId).map { it?.transform() }

    override fun getAll() =
        dao.getAll().map { list -> list.map { it.transform() } }

    override suspend fun deleteById(id: Long) =
        dao.deleteById(id)

    override suspend fun deleteAll() =
        dao.deleteAll()
}
