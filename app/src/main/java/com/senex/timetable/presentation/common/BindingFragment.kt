package com.senex.timetable.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

abstract class BindingFragment<T : ViewBinding> : DaggerFragment() {
    private var binding: T? = null

    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    protected abstract fun T.onViewCreated()

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = inflateBinding(bindingInflater, layoutInflater, container) {
        binding = it
    }

    @CallSuper
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        binding?.onViewCreated()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}



