package com.senex.timetable.domain.usecase

class SyncAllGroups(
    private val getAllRemoteGroups: GetAllRemoteGroups,
    private val deleteAllGroups: DeleteAllGroups,
    private val saveAllGroups: SaveAllGroups,
) {
    suspend operator fun invoke() {
        getAllRemoteGroups()?.let {
            deleteAllGroups()
            saveAllGroups(it)
        }
    }
}