package com.senex.timetable.presentation.common.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupsRecyclerItem

object GroupRecyclerItemConverter {
    fun convert(
        source: LiveData<List<Group>>,
    ) = source.map {
        val result = mutableListOf<GroupsRecyclerItem>()

        var currentCourseNumber = -1
        for (group in it) {
            if (group.courseNumber != currentCourseNumber) {
                currentCourseNumber = group.courseNumber
                result.add(GroupsRecyclerItem.CourseItem(currentCourseNumber))
            }
            result.add(GroupsRecyclerItem.GroupItem(group))
        }

        result.toList()
    }
}