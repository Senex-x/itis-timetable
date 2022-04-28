package com.senex.timetable.presentation.common

import android.content.SharedPreferences
import javax.inject.Inject

class GroupSharedPrefsHandler @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    fun saveGroupId(id: Long) = sharedPreferences.edit()
        .putLong(PREF_GROUP_ID_KEY, id)
        .apply()

    fun getSavedGroupId(): Long? {
        val id = sharedPreferences
            .getLong(PREF_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else null
    }

    companion object {
        private const val PREF_GROUP_ID_KEY =
            "group_id"
    }
}