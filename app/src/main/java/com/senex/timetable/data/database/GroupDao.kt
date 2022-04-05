package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.entity.group.GroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupDao: BaseDao<GroupEntity> {
    @Query("SELECT * FROM groups WHERE id = :id")
    fun get(id: Long): Flow<GroupEntity?>

    @Query("SELECT * FROM groups")
    fun getAll(): Flow<List<GroupEntity>>

    @Query("DELETE FROM groups WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM groups")
    suspend fun deleteAll()
}