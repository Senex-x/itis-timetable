package com.senex.timetable.data.database

import com.senex.timetable.data.models.group.Group
import com.senex.timetable.data.models.schedule.DailyScheduleEntity
import com.senex.timetable.data.models.schedule.ScheduleEntity
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.data.models.schedule.SubjectType
import com.senex.timetable.utils.log
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.random.Random

class DatabaseFiller @Inject constructor(
    private val database: AppDatabase
    ) {
    fun clearDatabase() = database.clearAllTables()

    fun populateDatabase() {
        log("Started populating database")

        for (i in 1..20L) {
            runBlocking {
                database.groupDao().insert(
                    createGroup(i)
                )
            }
        }
        log("Groups created")

        for (i in 1..20L) {
            runBlocking {
                database.scheduleDao().insert(
                    createSchedule(i, i)
                )
            }
        }
        log("Schedules created")

        for (i in 1..100L) {
            runBlocking {
                database.dailyScheduleDao().insert(
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
                database.subjectDao().insert(
                    createSubject(
                        i,
                        i % 100 + 1
                    )
                )
            }
        }
        log("Subjects created")
    }

    // TODO: make private after testing
    fun createGroup(id: Long) = Group(
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
}