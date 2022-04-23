package com.senex.timetable.presentation.common

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

fun MaterialToolbar.initNavToolbar(navController: NavController) =
    setupWithNavController(
        navController
    )