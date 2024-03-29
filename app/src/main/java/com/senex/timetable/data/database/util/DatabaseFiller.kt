package com.senex.timetable.data.database.util

import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.model.schedule.DailyScheduleInfo
import com.senex.timetable.domain.model.schedule.ScheduleInfo
import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.repository.local.DailyScheduleRepository
import com.senex.timetable.domain.repository.local.GroupRepository
import com.senex.timetable.domain.repository.local.ScheduleRepository
import com.senex.timetable.domain.repository.local.SubjectRepository
import com.senex.timetable.domain.util.log
import javax.inject.Inject
import kotlin.random.Random

class DatabaseFiller @Inject constructor(
    private val groupRepository: GroupRepository,
    private val scheduleRepository: ScheduleRepository,
    private val dailyScheduleRepository: DailyScheduleRepository,
    private val subjectRepository: SubjectRepository,
    private val database: AppDatabase,
    private val databaseLogger: DatabaseLogger,
) {
    fun clearDatabase() = database.clearAllTables()

    suspend fun populateDatabase() {
        log("Populating database...")

        for (i in 1..20L) {
            groupRepository.insert(
                createGroup(i)
            )
        }

        for (i in 1..20L) {

            scheduleRepository.insert(
                createSchedule(i, i)
            )
        }

        for (i in 1..120L) {
            dailyScheduleRepository.insert(
                createDailySchedule(
                    i,
                    (i - 1) % 20 + 1
                )
            )
        }

        for (i in 1..600L) {
            subjectRepository.insert(
                createSubject(
                    i,
                    (i - 1) % 120 + 1
                )
            )
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
        dailyScheduleId, null, null,
        true, false,
        Subject.Periodicity.EVERY_WEEK,
        Random.nextInt(1, 10),
        "8:30", "10:00",
        "Computer Science",
        "130" + Random.nextInt(0, 10),
        Subject.Type.values().random(), Subject.Kind.ORDINARY,
        "Azat", "Vatafac", "Shavkatovich"
    )
}
