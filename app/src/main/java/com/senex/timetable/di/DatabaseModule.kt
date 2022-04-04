package com.senex.timetable.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.util.DatabaseFiller
import dagger.Lazy
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module(includes = [DaoModule::class])
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        appContext: Context,
        databaseFiller: Lazy<DatabaseFiller>,
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "database-main"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                CoroutineScope(Dispatchers.Default).launch {
                    databaseFiller.get().prepareDatabase()
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                CoroutineScope(Dispatchers.Default).launch {
                    //prepareDatabase(databaseLazy.get())
                }
            }
        }).build()
    }

    private fun DatabaseFiller.prepareDatabase() {
        clearDatabase()
        populateDatabase()
    }
}