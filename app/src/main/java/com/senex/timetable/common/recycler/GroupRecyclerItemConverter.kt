package com.senex.timetable.common.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.map
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.ui.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.ui.groups.recycler.items.GroupRecyclerItem

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

        result
    }
}