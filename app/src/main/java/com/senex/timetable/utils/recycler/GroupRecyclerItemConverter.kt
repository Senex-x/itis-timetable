package com.senex.timetable.utils.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.presentation.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem

object GroupRecyclerItemConverter {
    fun convert(
        source: LiveData<List<Group>>,
    ) = Transformations.map(source) {
        if(it == null) return@map emptyList()

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