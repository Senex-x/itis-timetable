package com.senex.timetable.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.presentation.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.utils.recycler.TypedRecyclerItem

object GroupListConverter {
    fun convert(
        list: LiveData<List<Group>>,
    ): LiveData<List<TypedRecyclerItem>> {
        val liveListItems = MutableLiveData<List<TypedRecyclerItem>>()

        list.observeForever {
            liveListItems.value = convertList(it)
        }

        return liveListItems
    }

    private fun convertList(
        list: List<Group>
    ): List<TypedRecyclerItem> {
        val result = mutableListOf<TypedRecyclerItem>()
        val sortedGroupList = list.sortedWith(
            Comparator.comparingInt(Group::courseNumber)
        )

        var currentCourseNumber = -1
        for(group in sortedGroupList) {
            if(group.courseNumber != currentCourseNumber) {
                currentCourseNumber = group.courseNumber
                result.add(CourseRecyclerItem(currentCourseNumber))
            }
            result.add(GroupRecyclerItem(group))
        }

        return result
    }
}