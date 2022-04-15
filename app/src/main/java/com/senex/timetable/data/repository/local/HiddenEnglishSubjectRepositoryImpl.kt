package com.senex.timetable.data.repository.local

import com.senex.timetable.data.database.HiddenEnglishSubjectDao
import com.senex.timetable.data.mapper.transform
import com.senex.timetable.domain.model.subject.HiddenEnglishSubject
import com.senex.timetable.domain.repository.local.HiddenEnglishSubjectRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HiddenEnglishSubjectRepositoryImpl @Inject constructor(
    private val dao: HiddenEnglishSubjectDao,
) : HiddenEnglishSubjectRepository {

    override suspend fun insert(item: HiddenEnglishSubject) =
        dao.insert(item.transform())

    override suspend fun insertAll(vararg items: HiddenEnglishSubject) =
        dao.insertAll(*items.map { it.transform() }.toTypedArray())

    override suspend fun update(item: HiddenEnglishSubject) =
        dao.update(item.transform())

    override suspend fun delete(item: HiddenEnglishSubject) =
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
