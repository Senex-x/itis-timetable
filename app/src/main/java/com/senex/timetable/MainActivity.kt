package com.senex.timetable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doOptionalStuff()
    }

    private fun doOptionalStuff() {
        /*
        subjectRepository.getAllByGroupIdAndDayNumber(1, 1)
            .observe(this) {
            log(it.toString())
        }*/
    }
}