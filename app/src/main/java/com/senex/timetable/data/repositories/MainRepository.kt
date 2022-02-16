package com.senex.timetable.data.repositories

import com.senex.timetable.data.models.*
import com.senex.timetable.presentation.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.utils.recycler.TypedRecyclerItem
import com.senex.timetable.presentation.schedule.recycler.items.DayRecyclerItem
import com.senex.timetable.presentation.schedule.recycler.items.SubjectRecyclerItem
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

    fun getGroupListItems(): List<TypedRecyclerItem> {
        val items = mutableListOf<TypedRecyclerItem>()
        val groups = getGroups()

        for(i in 1..4) {
            val list = groups[i]

            list?.let {
                items.add(CourseRecyclerItem(i))

                for(group in list) {
                    items.add(GroupRecyclerItem(group))
                }
            }
        }

        return items
    }

    fun getScheduleListItems(): List<TypedRecyclerItem> {
        val items = mutableListOf<TypedRecyclerItem>()
        val groupSchedule = getGroupSchedule()

        for (day in groupSchedule.dailySchedules) {
            items.add(DayRecyclerItem(
                day.name
            ))
            for (subject in day.subjects) {
                items.add(SubjectRecyclerItem(
                    subject
                ))
            }
        }

        return items
    }

    private fun getGroupSchedule() = GroupSchedule(
        1,
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