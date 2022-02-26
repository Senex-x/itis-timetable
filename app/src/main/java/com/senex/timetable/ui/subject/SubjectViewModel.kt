package com.senex.timetable.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.models.schedule.Subject
import com.senex.timetable.data.repositories.SubjectRepository
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository,
) : ViewModel() {
    private var subject: Subject? = null

    suspend fun setSubject(subjectId: Long) {
        subject = subjectRepository.get(subjectId)
    }

    fun getSubject() = subject!!
}