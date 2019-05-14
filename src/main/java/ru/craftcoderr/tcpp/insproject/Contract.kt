package ru.craftcoderr.tcpp.insproject

class Contract(
    var client: Client,
    var premium: Int,
    var state: ContractState,
    var flag: StateFlag,
    var enterTime: Long = 0,
    var expiresAt: Long = 0,
    var dissolveReason: String? = null
) {

    fun enter() {
        state.enter()
    }

    fun cancel() {
        state.cancel()
    }

    fun dissolve(reason: String) {
        state.dissolve(reason)
    }

    fun complete() {
        state.complete()
    }

    fun isExpired() : Boolean {
        return System.currentTimeMillis() >= expiresAt
    }

    fun persist() {

    }

}