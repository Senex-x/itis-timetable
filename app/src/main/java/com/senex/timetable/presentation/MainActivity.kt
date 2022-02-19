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

        doOptionalStuff()
    }

    private fun doOptionalStuff() {
        runBlocking {
            val db = MainDatabase()
            val groupDao = db.groupDao()
            val scheduleDao = db.scheduleDao()
            val dailyScheduleDao = db.dailyScheduleDao()

            log(scheduleDao.getSuspending(1).toString())
        }
    }
}