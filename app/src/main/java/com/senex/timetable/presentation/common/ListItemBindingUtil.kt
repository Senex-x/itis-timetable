package com.senex.timetable.presentation.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

internal fun <T : ViewBinding> bindListItemView(
    binder: (View) -> T,
    parent: ViewGroup,
    layout: Int,
) = binder(
    LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
)