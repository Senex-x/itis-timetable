package com.senex.timetable.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.senex.timetable.data.database.AppDatabase
import com.senex.timetable.data.database.DatabaseFiller
import dagger.Lazy
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        appContext: Context,
        databaseLazy: Lazy<AppDatabase>,
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "database-main"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                CoroutineScope(Dispatchers.Default).launch {
                    val databaseFiller = DatabaseFiller(databaseLazy.get())

                    //databaseFiller.clearDatabase()
                    //databaseFiller.populateDatabase()
                }
            }
        }).build()
    }
}