package com.senex.timetable.presentation.common.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.presentation.ui.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.ui.groups.recycler.items.GroupRecyclerItem

object GroupRecyclerItemConverter {
    fun convert(
        source: LiveData<List<Group>>,
    ) = source.map {
        val result = mutableListOf<TypedRecyclerItem>()

        var currentCourseNumber = -1
        for (group in it) {
            if (group.courseNumber != currentCourseNumber) {
                currentCourseNumber = group.courseNumber
                result.add(CourseRecyclerItem(currentCourseNumber))
            }
            result.add(GroupRecyclerItem(group))
        }

        result.toList()
    }
}