package com.senex.timetable.common

import android.content.Context
import android.content.SharedPreferences
import java.lang.IllegalStateException
import javax.inject.Inject

private const val PREF_FILE_NAME =
    "com.senex.timetable.PREFERENCES"
private const val PREF_GROUP_ID_KEY =
    "group_id"

class SharedPreferencesHandler @Inject constructor(
    context: Context,
) {
    private val sharedPreferences: SharedPreferences = context.applicationContext
        .getSharedPreferences(
            PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )

    val isGroupNotSaved
        get() = getSavedGroupIdNullable() == null

    fun saveGroupId(id: Long) = sharedPreferences.edit()
        .putLong(PREF_GROUP_ID_KEY, id)
        .apply()

    fun getSavedGroupId(): Long {
        val id = sharedPreferences
            .getLong(PREF_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else throw IllegalStateException()
    }

    private fun getSavedGroupIdNullable(): Long? {
        val id = sharedPreferences
            .getLong(PREF_GROUP_ID_KEY, -1L)
        return if (id != -1L) id else null
    }
}