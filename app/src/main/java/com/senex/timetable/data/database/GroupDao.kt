package com.senex.timetable.data.database

import androidx.room.Dao
import androidx.room.Query
import com.senex.timetable.data.database.util.BaseDao
import com.senex.timetable.domain.entities.group.Group

@Dao
interface GroupDao: BaseDao<Group> {
    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun get(id: Long): Group?

    @Query("SELECT * FROM groups")
    suspend fun getAll(): List<Group>

    @Query("DELETE FROM groups WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM groups")
    suspend fun deleteAll()
}