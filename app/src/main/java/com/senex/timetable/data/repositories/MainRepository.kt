package com.senex.timetable.data.repositories

import com.senex.timetable.data.models.*
import com.senex.timetable.presentation.fragments.groups.recycler.items.CourseItem
import com.senex.timetable.presentation.fragments.groups.recycler.items.GroupItem
import com.senex.timetable.presentation.fragments.groups.recycler.items.GroupListItem
import com.senex.timetable.presentation.fragments.schedule.recycler.items.DayItem
import com.senex.timetable.presentation.fragments.schedule.recycler.items.ScheduleListItem
import com.senex.timetable.presentation.fragments.schedule.recycler.items.SubjectItem
import kotlin.random.Random

object MainRepository {
    fun getGroupsList(count: Int): List<Group> {
        val list = mutableListOf<Group>()

        for (i in 1..count) {
            list.add(Group(
                Random.nextLong(),
                Random.nextInt(10, 20).toString() + "-" +
                        Random.nextInt(100, 1000).toString(),
                Random.nextInt(1, 5)
            ))
        }

        return list
    }

    fun getGroups(count: Int = 20): Map<Int, List<Group>> {
        val map = mutableMapOf<Int, List<Group>>()
        val intermediateMap = mutableMapOf<Int, MutableList<Group>>()

        for (i in 1..count) {
            val courseNumber = Random.nextInt(1, 5)

            val group = Group(
                Random.nextLong(),
                Random.nextInt(10, 20).toString() + "-" +
                        Random.nextInt(100, 1000).toString(),
                courseNumber
            )

            intermediateMap
                .getOrPut(courseNumber) { mutableListOf() }
                .add(group)
        }

        for ((key, list) in intermediateMap) {
            map[key] = list
        }

        return map
    }

    fun getGroupListItems(): List<GroupListItem> {
        val items = mutableListOf<GroupListItem>()
        val groups = getGroups()

        for(i in 1..4) {
            val list = groups[i]

            list?.let {
                items.add(CourseItem(i))

                for(group in list) {
                    items.add(GroupItem(group))
                }
            }
        }

        return items
    }

    fun getScheduleListItems(): List<ScheduleListItem> {
        val items = mutableListOf<ScheduleListItem>()
        val groupSchedule = getGroupSchedule()

        for (day in groupSchedule.dailySchedules) {
            items.add(DayItem(
                day.name
            ))
            for (subject in day.subjects) {
                items.add(SubjectItem(
                    subject
                ))
            }
        }

        return items
    }

    private fun getGroupSchedule() = GroupSchedule(
        "11-005",
        listOf(
            DaySchedule(
                1,
                "Monday",
                listOf(
                    Subject(
                        "8:30", "10:00",
                        "Mathematical analysis",
                        "1306",
                        SubjectType.SEMINAR,
                        true, true,
                        "Galeev", "Ruslan", "Tagirovich"
                    ),
                    Subject(
                        "10:10", "11:40",
                        "Database science",
                        "1309",
                        SubjectType.SEMINAR,
                        true, true,
                        "Azat", "Ruslan", "Shavkatovich"
                    )
                )
            ),
            DaySchedule(
                2,
                "Tuesday",
                listOf(
                    Subject(
                        "8:30", "10:00",
                        "Mathematical analysis",
                        "1306",
                        SubjectType.SEMINAR,
                        true, true,
                        "Galeev", "Ruslan", "Tagirovich"
                    ),
                    Subject(
                        "10:10", "11:40",
                        "Database science",
                        "1309",
                        SubjectType.SEMINAR,
                        true, true,
                        "Azat", "Ruslan", "Shavkatovich"
                    )
                )
            )
        )
    )
}