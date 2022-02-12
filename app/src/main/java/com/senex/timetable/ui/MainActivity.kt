package com.senex.timetable.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senex.timetable.databinding.ActivityMainBinding
import com.senex.timetable.models.entities.DaySchedule
import com.senex.timetable.models.entities.GroupSchedule
import com.senex.timetable.models.entities.Subject
import com.senex.timetable.models.entities.SubjectType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}

val groupScheduleDemo = GroupSchedule(
    "11-005",
    listOf(
        DaySchedule(
            1,
            "Monday",
            listOf(
                Subject(
                    "8:30", "10:00",
                    "Mathematical analysis",
                    "1306",
                    SubjectType.Seminar,
                    true, true,
                    "Galeev", "Ruslan", "Tagirovich"
                ),
                Subject(
                    "10:10", "11:40",
                    "Database science",
                    "1309",
                    SubjectType.Seminar,
                    true, true,
                    "Azat", "Ruslan", "Shavkatovich"
                )
            )
        ),
        DaySchedule(
            2,
            "Tuesday",
            listOf(
                Subject(
                    "8:30", "10:00",
                    "Mathematical analysis",
                    "1306",
                    SubjectType.Seminar,
                    true, true,
                    "Galeev", "Ruslan", "Tagirovich"
                ),
                Subject(
                    "10:10", "11:40",
                    "Database science",
                    "1309",
                    SubjectType.Seminar,
                    true, true,
                    "Azat", "Ruslan", "Shavkatovich"
                )
            )
        )
    )
)