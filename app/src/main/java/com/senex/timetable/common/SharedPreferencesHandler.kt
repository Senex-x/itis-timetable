package com.senex.timetable.common

import android.content.Context
import android.content.SharedPreferences
import java.lang.IllegalStateException
import javax.inject.Inject

private const val PREF_GROUP_ID_KEY =
    "group_id"

class SharedPreferencesHandler @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    val isGroupSaved
        get() = getSavedGroupId() != null

    fun saveGroupId(id: Long) = sharedPreferences.edit()
        .putLong(PREF_GROUP_ID_KEY, id)
        .apply()

    fun getSavedGroupId(): Long? {
        val id = sharedPreferences
            .getLong(PREF_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else null
    }
}