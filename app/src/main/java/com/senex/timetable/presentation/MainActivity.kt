package com.senex.timetable.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.databinding.ActivityMainBinding
import com.senex.timetable.utils.SharedPreferencesUtil
import com.senex.timetable.utils.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doOptionalLogging()
    }

    private fun doOptionalLogging() {
        log(SharedPreferencesUtil(applicationContext)
            .getSavedGroupId().toString()
        )
    }
}