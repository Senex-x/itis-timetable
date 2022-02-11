package com.senex.timetable.models.repositories

import com.senex.timetable.models.entities.Group
import kotlin.random.Random

object EntityRepository {
    fun getEntities(count: Int): List<Group> {
        val list = mutableListOf<Group>()

        for (i in 1..count) {
            list.add(Group(
                Random.nextInt(10, 20).toString() + "-" +
                        Random.nextInt(100, 1000).toString()
            ))
        }

        return list
    }
}