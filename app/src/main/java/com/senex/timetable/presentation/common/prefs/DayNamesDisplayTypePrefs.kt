package com.senex.timetable.presentation.common.prefs

import android.content.SharedPreferences
import com.senex.timetable.presentation.common.prefs.constants.DayNamesDisplayType
import javax.inject.Inject

class DayNamesDisplayTypePrefs @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveDisplayType(type: DayNamesDisplayType) = sharedPreferences.edit()
        .putString(PREF_DISPLAY_TYPE_KEY, type.name)
        .apply()

    fun getDisplayType() = DayNamesDisplayType.valueOf(
        sharedPreferences.getString(
            PREF_DISPLAY_TYPE_KEY,
            DayNamesDisplayType.FULL.name
        )!!
    )

    companion object {
        private const val PREF_DISPLAY_TYPE_KEY =
            "day_display_type"
    }
}