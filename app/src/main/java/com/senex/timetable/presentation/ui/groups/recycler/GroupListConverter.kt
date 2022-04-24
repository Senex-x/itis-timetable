package com.senex.timetable.presentation.ui.groups.recycler

import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.usecase.schedule.IsSchedulePresent
import com.senex.timetable.domain.util.log

/**
 * Works properly only if the list is sorted by the course number.
 */
suspend fun List<Group>.toGroupsRecyclerItemList(
    isSchedulePresent: IsSchedulePresent,
) = buildList {
    var currentCourseNumber = -1
    for (group in this@toGroupsRecyclerItemList) {
        if (group.courseNumber != currentCourseNumber) {
            currentCourseNumber = group.courseNumber
            add(GroupsRecyclerItem.CourseItem(currentCourseNumber))
        }
        add(GroupsRecyclerItem.GroupItem(group, isSchedulePresent(group.id)))
    }
}
