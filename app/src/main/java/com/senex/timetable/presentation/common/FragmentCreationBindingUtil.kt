package com.senex.timetable.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> inflateBinding(
    bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T,
    layoutInflater: LayoutInflater,
    root: ViewGroup?,
    initializer: (T) -> Unit,
) = bindingInflater(layoutInflater, root, false).also(initializer).root