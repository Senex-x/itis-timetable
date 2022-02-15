package com.senex.timetable.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.senex.timetable.data.models.Group
import com.senex.timetable.presentation.groups.recycler.items.CourseItem
import com.senex.timetable.presentation.groups.recycler.items.GroupItem
import com.senex.timetable.presentation.groups.recycler.items.GroupListItem

object GroupListConverter {
    fun convert(
        list: LiveData<List<Group>>,
    ): LiveData<List<GroupListItem>> {
        val liveListItems = MutableLiveData<List<GroupListItem>>()

        list.observeForever {
            liveListItems.value = convertList(it)
        }

        return liveListItems
    }

    private fun convertList(
        list: List<Group>
    ): List<GroupListItem> {
        val result = mutableListOf<GroupListItem>()
        val sortedGroupList = list.sortedWith(
            Comparator.comparingInt(Group::courseNumber)
        )

        var currentCourseNumber = -1
        for(group in sortedGroupList) {
            if(group.courseNumber != currentCourseNumber) {
                currentCourseNumber = group.courseNumber
                result.add(CourseItem(currentCourseNumber))
            }
            result.add(GroupItem(group))
        }

        return result
    }
}