package com.senex.timetable.domain.usecase

import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SyncAllGroups @Inject constructor(
    private val getAllRemoteGroups: GetAllRemoteGroups,
    private val getAllGroups: GetAllGroups,
    private val deleteAllGroups: DeleteAllGroups,
    private val saveAllGroups: SaveAllGroups,
) {
    suspend operator fun invoke() {
        getAllRemoteGroups()?.let { remoteGroups ->
            val localGroups = getAllGroups().first()
            if (!localGroups.containsAll(remoteGroups)
                || !remoteGroups.containsAll(localGroups)
            ) {
                deleteAllGroups()
                saveAllGroups(remoteGroups)
            }
        }
    }
}