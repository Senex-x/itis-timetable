package com.senex.timetable.model.entities

data class AllGroups(
    val coursesWithGroups: Map<Int, Group>,
)