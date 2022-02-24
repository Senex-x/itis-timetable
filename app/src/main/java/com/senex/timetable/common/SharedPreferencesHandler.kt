package com.senex.timetable.common

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

private const val PREF_FILE_NAME =
    "com.senex.timetable.MAIN_PREFERENCES"
private const val PREF_GROUP_ID_KEY =
    "group-id"

class SharedPreferencesHandler @Inject constructor(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences = context.applicationContext
        .getSharedPreferences(
            PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )

    fun saveGroupId(id: Long) = sharedPreferences
        .edit()
        .putLong(PREF_GROUP_ID_KEY, id)
        .apply()

    fun getSavedGroupId(): Long? {
        val id = sharedPreferences
            .getLong(PREF_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else null
    }
}