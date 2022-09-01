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
) {
    suspend operator fun invoke(groupId: Long) {
        getRemoteScheduleByGroupId(groupId)?.let {
            val localSchedule = getScheduleByGroupIdSorted(groupId).first()
            if (localSchedule == null || !areSchedulesSameLazy(localSchedule, it)) {
                deleteGroupById(groupId)
                saveSchedule(it)
                "Schedule sync done".log()
            } else {
                "Schedule sync canceled, no changes detected".log()
            }
        }
    }

    // TODO: BRUH optimize this
    private fun areSchedulesSameLazy(first: Schedule, second: Schedule): Boolean {
        return true
//        var result = false
//        for (firstDailySchedule in first.dailySchedules) {
//            for (secondDailySchedule in second.dailySchedules) {
//                for (firstSubject in firstDailySchedule.subjects) {
//                    for (secondSubject in secondDailySchedule.subjects) {
//                        result = firstSubject.dailyScheduleId == secondSubject.dailyScheduleId
//                                && firstSubject.electiveSubjectId == secondSubject.electiveSubjectId
//                                && firstSubject.englishSubjectId == secondSubject.englishSubjectId
//                                && firstSubject.indexInDay == secondSubject.indexInDay
//                                && firstSubject.startTime == secondSubject.startTime
//                                && firstSubject.endTime == secondSubject.endTime
//                                && firstSubject.name == secondSubject.name
//                                && firstSubject.room == secondSubject.room
//                                && firstSubject.type == secondSubject.type
//                                && firstSubject.kind == secondSubject.kind
//                                && firstSubject.teacherName == secondSubject.teacherName
//                                && firstSubject.teacherPatronymic == secondSubject.teacherPatronymic
//                                && firstSubject.teacherSurname == secondSubject.teacherSurname
//                    }
//                }
//            }
//        }
//        return result
    }
}
