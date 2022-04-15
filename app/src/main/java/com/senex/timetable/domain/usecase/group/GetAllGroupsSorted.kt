package com.senex.timetable.domain.usecase.group

import com.senex.timetable.domain.model.group.Group
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllGroupsSorted @Inject constructor(
    private val getAllGroups: GetAllGroups,
) {
    operator fun invoke() = getAllGroups().map { list ->
        list.sortedWith(groupComparator)
    }

    private val groupComparator = Comparator<Group> { group1, group2 ->
        val courseNumber1 = group1.courseNumber
        val courseNumber2 = group2.courseNumber
        val compareCourseNumbersResult = courseNumber1.compareTo(courseNumber2)

        return@Comparator if (compareCourseNumbersResult != 0) {
            compareCourseNumbersResult
        } else {
            val groupNumber1 = group1.name.substring(3) // 11-005
            val groupNumber2 = group2.name.substring(3)

            groupNumber1.compareTo(groupNumber2)
        }
    }
}