package com.senex.timetable.presentation.ui.subject.varied

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.senex.timetable.presentation.common.inflateBinding
import dagger.android.support.DaggerFragment

abstract class BindingFragment<T : ViewBinding> : DaggerFragment() {
    private var _binding: T? = null
    protected val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(bindingInflater, layoutInflater, container) {
        _binding = it
    }

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = onViewCreatedCallback(binding)

    protected abstract val onViewCreatedCallback: T.() -> Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


