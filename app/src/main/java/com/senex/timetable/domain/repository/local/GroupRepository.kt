package com.senex.timetable.domain.repository.local

import com.senex.timetable.domain.model.group.Group
import com.senex.timetable.domain.repository.local.BaseRepository

interface GroupRepository: BaseRepository<Group, Group, Long>