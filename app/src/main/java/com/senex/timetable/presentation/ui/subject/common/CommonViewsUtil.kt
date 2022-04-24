package com.senex.timetable.presentation.ui.subject.common

import android.view.View
import androidx.lifecycle.LifecycleCoroutineScope
import com.senex.timetable.databinding.SubjectShowHideButtonsBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

internal fun SubjectShowHideButtonsBinding.initShowHideSubjectButtons(
    lifecycleScope: LifecycleCoroutineScope,
    isSubjectVisible: Flow<Boolean>,
    subjectVisibilitySetter: (isVisible: Boolean) -> Unit,
) {
    lifecycleScope.launch {
        isSubjectVisible.collect {
            if (it) {
                showSubjectButton.visibility = View.INVISIBLE
                hideSubjectButton.visibility = View.VISIBLE
            } else {
                showSubjectButton.visibility = View.VISIBLE
                hideSubjectButton.visibility = View.INVISIBLE
            }
        }
    }
    hideSubjectButton.setOnClickListener {
        subjectVisibilitySetter(false)
    }
    showSubjectButton.setOnClickListener {
        subjectVisibilitySetter(true)
    }
}