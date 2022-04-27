package com.senex.timetable.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

abstract class BindingFragment<T : ViewBinding> : DaggerFragment() {
    private var _binding: T? = null
    private val binding
        get() = _binding!!

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(bindingInflater, layoutInflater, container) {
        _binding = it
    }

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    @CallSuper
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) = binding.onViewCreated()

    protected abstract fun T.onViewCreated()

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


