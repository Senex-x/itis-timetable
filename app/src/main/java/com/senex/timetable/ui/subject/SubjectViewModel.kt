package com.senex.timetable.ui.subject

import androidx.lifecycle.ViewModel
import com.senex.timetable.data.models.subject.Subject
import com.senex.timetable.data.repositories.HiddenSubjectRepository
import com.senex.timetable.data.repositories.SubjectRepository
import javax.inject.Inject

class SubjectViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository,
    private val hiddenSubjectRepository: HiddenSubjectRepository,
) : ViewModel() {
    private var subject: Subject? = null

    suspend fun setSubject(subjectId: Long) {
        subject = subjectRepository.get(subjectId)
    }

    fun getSubject() = subject!!
}