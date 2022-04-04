package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.entities.group.Group
import com.senex.timetable.domain.repository.GroupRepository

class GetAllGroupsSorted(
    private val groupRepository: GroupRepository,
) {
    suspend operator fun invoke() = groupRepository.getAll().sortedWith(groupComparator)

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