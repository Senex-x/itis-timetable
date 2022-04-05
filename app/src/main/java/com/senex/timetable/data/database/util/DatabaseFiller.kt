package com.senex.timetable.data.database.util

import com.senex.timetable.domain.util.log
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo
import com.senex.timetable.domain.model.schedule.ScheduleInfo
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.model.subject.SubjectType
import com.senex.timetable.domain.repository.DailyScheduleRepository
import com.senex.timetable.domain.repository.GroupRepository
import com.senex.timetable.domain.repository.ScheduleRepository
import com.senex.timetable.domain.repository.SubjectRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import kotlin.random.Random

class DatabaseFiller @Inject constructor(
    private val groupRepository: GroupRepository,
    private val scheduleRepository: ScheduleRepository,
    private val dailyScheduleRepository: DailyScheduleRepository,
    private val subjectRepository: SubjectRepository,
    private val database: AppDatabase,
) {
    fun clearDatabase() = database.clearAllTables()

    fun populateDatabase() {
        for (i in 1..20L) {
            runBlocking {
                groupRepository.insert(
                    createGroup(i)
                )
            }
        }

        for (i in 1..20L) {
            runBlocking {
                scheduleRepository.insert(
                    createSchedule(i, i)
                )
            }
        }

        for (i in 1..120L) {
            runBlocking {
                dailyScheduleRepository.insert(
                    createDailySchedule(
                        i,
                        (i - 1) % 20 + 1
                    )
                )
            }
        }

        for (i in 1..600L) {
            runBlocking {
                subjectRepository.insert(
                    createSubject(
                        i,
                        (i - 1) % 120 + 1
                    )
                )
            }
        }

        log("Database was populated successfully")
    }

    // TODO: make private after testing
    fun createGroup(id: Long) = Group(
        id,
        Random.nextInt(10, 20).toString() + "-" +
                Random.nextInt(100, 1000).toString(),
        Random.nextInt(1, 6)
    )

    private fun createSchedule(id: Long, groupId: Long) = ScheduleInfo(
        id,
        groupId
    )

    private val dayNames =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    private fun createDailySchedule(id: Long, scheduleId: Long) = DailyScheduleInfo(
        id,
        scheduleId,
        dayNames.random(),
        (id / 20).toInt()
    )

    private fun createSubject(id: Long, dailyScheduleId: Long) = Subject(
        id,
        dailyScheduleId,
        Random.nextInt(1, 10),
        "8:30", "10:00",
        "Computer Science",
        "130" + Random.nextInt(0, 10),
        SubjectType.values().random(),
        true, true,
        "Azat", "Vatafac", "Shavkatovich"
    )
}