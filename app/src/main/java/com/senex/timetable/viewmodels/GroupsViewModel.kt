package com.senex.timetable.viewmodels

import androidx.lifecycle.ViewModel
import com.senex.timetable.model.entities.Group
import com.senex.timetable.model.repositories.MainRepository

class GroupsViewModel : ViewModel() {
    private val groups: List<Group> by lazy {
        MainRepository.getGroups(20)
    }

    fun getGroupList() = groups

    fun getGroup(id: Long) =
        groups.find { item -> item.id == id } ?: throw IllegalArgumentException()

    fun setPrimaryGroup(groupId: Long) {
        // TODO: save state
    }
}