package com.senex.timetable.model.repositories

import com.senex.timetable.model.entities.*
import com.senex.timetable.ui.fragments.groups.recycler.items.GroupListItem
import com.senex.timetable.ui.fragments.schedule.recycler.items.DayItem
import com.senex.timetable.ui.fragments.schedule.recycler.items.ScheduleListItem
import com.senex.timetable.ui.fragments.schedule.recycler.items.SubjectItem
import kotlin.random.Random

object MainRepository {
    fun getGroups(count: Int): List<Group> {
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

    fun getAllGroups() {
        val groups = getGroups(20)
            .sortedWith(Comparator.comparingLong { group -> group.id!! })

    }

    fun getGroupListItems(): List<GroupListItem> {
        val items = mutableListOf<GroupListItem>()
        val groups = getGroups(20)
            .sortedWith(Comparator.comparingLong { group -> group.id!! })

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
                        SubjectType.Seminar,
                        true, true,
                        "Galeev", "Ruslan", "Tagirovich"
                    ),
                    Subject(
                        "10:10", "11:40",
                        "Database science",
                        "1309",
                        SubjectType.Seminar,
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
                        SubjectType.Seminar,
                        true, true,
                        "Galeev", "Ruslan", "Tagirovich"
                    ),
                    Subject(
                        "10:10", "11:40",
                        "Database science",
                        "1309",
                        SubjectType.Seminar,
                        true, true,
                        "Azat", "Ruslan", "Shavkatovich"
                    )
                )
            )
        )
    )
}