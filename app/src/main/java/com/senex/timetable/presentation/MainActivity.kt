package com.senex.timetable.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.data.models.schedule.DailyScheduleEntity
import com.senex.timetable.data.repositories.MainRepository
import com.senex.timetable.databinding.ActivityMainBinding
import com.senex.timetable.utils.SharedPreferencesHandler
import com.senex.timetable.utils.log
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainDatabase.init(applicationContext)

        doOptionalStuff()
    }

    private fun doOptionalStuff() {

        MainRepository.populateDatabase()

        runBlocking {
            val db = MainDatabase()
            val dao = db.groupDao()

            //dao.deleteAll()
            //dao.insertAll(*MainRepository.getGroupsList(20).toTypedArray())

            dao.getAll()
                .observe(this@MainActivity) {
                    log("Observe: $it")
                }

            val schDao = db.scheduleDao()
            /*
            db.scheduleDao().insert(
                ScheduleEntity(
                    1, 2
                )
            )*/

            val dDao = db.dailyScheduleDao()
/*
            dDao.insert(DailyScheduleEntity(
                2,
                2,
                "name",
                1
            ))*/

            log("Daily all: " + dDao.getAll().toString())
        }

        log(SharedPreferencesHandler(applicationContext)
            .getSavedGroupId().toString()
        )
    }
}