package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.data.model.group.GroupEntity

@Dao
interface GroupDao: BaseDao<GroupEntity> {
    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun get(id: Long): GroupEntity?

    @Query("SELECT * FROM groups")
    suspend fun getAll(): List<GroupEntity>

    @Query("DELETE FROM groups WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM groups")
    suspend fun deleteAll()
}