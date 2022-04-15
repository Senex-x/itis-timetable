package com.senex.timetable.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.util.DatabaseFiller
import com.senex.timetable.domain.util.log
import dagger.Lazy
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineExceptionHandler
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
                CoroutineScope(Dispatchers.Default + exceptionHandler).launch {
                    databaseFiller.get().populateDatabase()
                }
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                CoroutineScope(Dispatchers.Default + exceptionHandler).launch {
                    //databaseFiller.get().clearDatabase()
                    //databaseFiller.get().prepareDatabase()
                }
            }
        }).build()
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        "Database filling failed with: $throwable".log()
    }
}