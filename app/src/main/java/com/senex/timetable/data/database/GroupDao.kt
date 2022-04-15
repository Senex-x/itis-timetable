package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.group.GroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao: BaseDao<GroupEntity, GroupEntity> {
    @Query("SELECT * FROM groups WHERE id = :id")
    override fun get(id: Long): Flow<GroupEntity?>

    @Query("SELECT * FROM groups")
    override fun getAll(): Flow<List<GroupEntity>>

    @Query("DELETE FROM groups WHERE id = :id")
    override suspend fun deleteById(id: Long)

    @Query("DELETE FROM groups")
    override suspend fun deleteAll()
}