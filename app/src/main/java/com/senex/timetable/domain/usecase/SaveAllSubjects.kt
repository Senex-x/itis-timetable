package com.senex.timetable.domain.usecase

import com.senex.timetable.domain.model.subject.Subject
import com.senex.timetable.domain.repository.local.SubjectRepository
import javax.inject.Inject

class SaveAllSubjects @Inject constructor(
    private val subjectRepository: SubjectRepository,
) {
    suspend operator fun invoke(subjects: List<Subject>) =
        subjectRepository.insertAll(*subjects.toTypedArray())
}