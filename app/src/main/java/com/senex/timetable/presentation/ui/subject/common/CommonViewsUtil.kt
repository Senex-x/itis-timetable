package com.senex.timetable.presentation.ui.subject.common

import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.LifecycleCoroutineScope
import com.google.android.material.appbar.MaterialToolbar
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

internal fun MaterialToolbar.setMenuItemColor(@IdRes itemId: Int, colorId: Int) =
    menu.findItem(itemId)
        .icon.setTint(resources.getColor(colorId, context.theme))