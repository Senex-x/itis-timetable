package com.senex.timetable.data.repositories

import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.models.group.Group
import com.senex.timetable.data.models.schedule.DailyScheduleEntity
import com.senex.timetable.data.models.schedule.ScheduleEntity
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.data.models.schedule.SubjectType
import com.senex.timetable.presentation.groups.recycler.items.CourseRecyclerItem
import com.senex.timetable.presentation.groups.recycler.items.GroupRecyclerItem
import com.senex.timetable.utils.log
import com.senex.timetable.utils.recycler.TypedRecyclerItem
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

object MainRepository {
    fun getGroupsList(count: Int): List<Group> {
        val list = mutableListOf<Group>()

        for (i in 1..count) {
            list.add(Group(
                i.toLong(),
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
                i.toLong(),
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

        for (i in 1..4) {
            val list = groups[i]

            list?.let {
                items.add(CourseRecyclerItem(i))

                for (group in list) {
                    items.add(GroupRecyclerItem(group))
                }
            }
        }

        return items
    }

    fun clearDatabase() {
        MainDatabase().clearAllTables()
    }

    fun populateDatabase() {
        val db = MainDatabase()
        log("Started populating database")

        runBlocking {
            db.subjectDao().deleteAll()
            db.dailyScheduleDao().deleteAll()
            db.scheduleDao().deleteAll()
            db.groupDao().deleteAll()
        }

        for (i in 1..20L) {
            runBlocking {
                db.groupDao().insert(
                    createGroup(i)
                )
            }
        }
        log("Groups created")

        for (i in 1..20L) {
            runBlocking {
                db.scheduleDao().insert(
                    createSchedule(i, i)
                )
            }
        }
        log("Schedules created")

        for (i in 1..100L) {
            runBlocking {
                db.dailyScheduleDao().insert(
                    createDailySchedule(
                        i,
                        i % 20 + 1
                    )
                )
            }
        }
        log("Daily schedules created")

        for (i in 1..500L) {
            runBlocking {
                db.subjectDao().insert(
                    createSubject(
                        i,
                        i % 100 + 1
                    )
                )
            }
        }
        log("Subjects created")
    }

    private fun createGroup(id: Long) = Group(
        id,
        Random.nextInt(10, 20).toString() + "-" +
                Random.nextInt(100, 1000).toString(),
        Random.nextInt(1, 5)
    )

    private fun createSchedule(id: Long, groupId: Long) = ScheduleEntity(
        id,
        groupId
    )

    private val dayNames =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Saturday", "Friday", "Sunday")

    private fun createDailySchedule(id: Long, scheduleId: Long) = DailyScheduleEntity(
        id,
        scheduleId,
        dayNames.random(),
        Random.nextInt(1, 8)
    )

    private fun createSubject(id: Long, dailyScheduleId: Long) = Subject(
        id,
        dailyScheduleId,
        "8:30", "10:00",
        "Computer Science",
        "130" + Random.nextInt(0, 10),
        SubjectType.values().random(),
        true, true,
        "Azat", "Vatafac", "Shavkatovich"
    )

/*
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

    private fun getGroupSchedule() = ScheduleEntity(
        1,
        1,
        listOf(
            DailyScheduleEntity(
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
            DailyScheduleEntity(
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
    )*/
}