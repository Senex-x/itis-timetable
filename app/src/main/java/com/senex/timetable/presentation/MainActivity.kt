package com.senex.timetable.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.data.database.MainDatabase
import com.senex.timetable.databinding.ActivityMainBinding
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

        //MainRepository.populateDatabase()

        runBlocking {
            val db = MainDatabase()
            val groupDao = db.groupDao()
            val scheduleDao = db.scheduleDao()
            val dailyScheduleDao = db.dailyScheduleDao()

            scheduleDao.get(1).observe(this@MainActivity) {
                log("Schedules: $it")
            }

            log(
                "Daily schedules: " + dailyScheduleDao.get(1).toString()
            )

            //dao.deleteAll()

            groupDao.getAll()
                .observe(this@MainActivity) {
                    log("Observe: $it")
                }
        }
/*
        log(SharedPreferencesHandler(applicationContext)
            .getSavedGroupId().toString()
        )*/
    }
}