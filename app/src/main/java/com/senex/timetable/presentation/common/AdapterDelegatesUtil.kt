package com.senex.timetable.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

class DelegateInflater<T : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
) {
    fun inflate(layoutInflater: LayoutInflater, root: ViewGroup) =
        bindingInflater(layoutInflater, root, false)
}