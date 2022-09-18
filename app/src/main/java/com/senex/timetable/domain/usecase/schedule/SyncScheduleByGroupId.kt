package com.senex.timetable.domain.usecase.schedule

import com.senex.timetable.domain.model.schedule.Schedule
import com.senex.timetable.domain.usecase.group.DeleteGroupById
import com.senex.timetable.domain.util.log
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SyncScheduleByGroupId @Inject constructor(
    private val getRemoteScheduleByGroupId: GetRemoteScheduleByGroupId,
    private val deleteGroupById: DeleteGroupById,
    private val saveSchedule: SaveSchedule,
    private val getScheduleByGroupIdSorted: GetScheduleByGroupIdSorted,
    private val sortSchedule: SortSchedule,
) {
    suspend operator fun invoke(groupId: Long) {
        getRemoteScheduleByGroupId(groupId)?.let {
            val remoteSchedule = sortSchedule(it)!!
            val localSchedule = getScheduleByGroupIdSorted(groupId).first()
            if (localSchedule == null || !areSchedulesSame(localSchedule, remoteSchedule)) {
                deleteGroupById(groupId)
                saveSchedule(it)
                "Schedule sync done".log()
            } else {
                "Schedule sync canceled, no changes detected".log()
            }
        }
    }

    private fun areSchedulesSame(first: Schedule, second: Schedule): Boolean {

        first.dailySchedules.forEachIndexed { dailyScheduleIndex, dailyScheduleFirst ->
            val dailyScheduleSecond = second.dailySchedules.getOrNull(dailyScheduleIndex) ?: return false

            dailyScheduleFirst.subjects.forEachIndexed { subjectIndex, subjectFirst ->
                val subjectSecond = dailyScheduleSecond.subjects.getOrNull(subjectIndex) ?: return false

                val areSubjectsSame = subjectFirst.dailyScheduleId == subjectSecond.dailyScheduleId
                        && subjectFirst.electiveSubjectId == subjectSecond.electiveSubjectId
                        && subjectFirst.englishSubjectId == subjectSecond.englishSubjectId
                        && subjectFirst.indexInDay == subjectSecond.indexInDay
                        && subjectFirst.startTime == subjectSecond.startTime
                        && subjectFirst.endTime == subjectSecond.endTime
                        && subjectFirst.name == subjectSecond.name
                        && subjectFirst.room == subjectSecond.room
                        && subjectFirst.type == subjectSecond.type
                        && subjectFirst.kind == subjectSecond.kind
                        && subjectFirst.teacherName == subjectSecond.teacherName
                        && subjectFirst.teacherPatronymic == subjectSecond.teacherPatronymic
                        && subjectFirst.teacherSurname == subjectSecond.teacherSurname

                if(!areSubjectsSame) return false
            }
        }

        return true
    }
}
