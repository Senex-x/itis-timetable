package com.senex.timetable.utils

import android.content.Context
import android.content.SharedPreferences

private const val SHARED_PREFERENCES_FILE_NAME =
    "com.senex.timetable.MAIN_PREFERENCES"
private const val SHARED_PREFERENCES_GROUP_ID_KEY =
    "group-id"

class SharedPreferencesHandler(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences = context.applicationContext
        .getSharedPreferences(
            SHARED_PREFERENCES_FILE_NAME,
            Context.MODE_PRIVATE
        )

    fun saveGroupId(id: Long) = sharedPreferences
        .edit()
        .putLong(SHARED_PREFERENCES_GROUP_ID_KEY, id)
        .apply()

    fun getSavedGroupId(): Long? {
        val id = sharedPreferences
            .getLong(SHARED_PREFERENCES_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else null
    }
}