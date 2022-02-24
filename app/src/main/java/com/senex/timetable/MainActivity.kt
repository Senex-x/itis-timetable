package com.senex.timetable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking
import java.time.DayOfWeek

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
            //log(scheduleDao.getSuspending(1).toString())
        }
    }
}