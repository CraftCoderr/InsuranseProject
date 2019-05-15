package ru.craftcoderr.tcpp.insproject

abstract class Contract(
    val client: Client,
    var state: ContractState,
    var flag: StateFlag,
    var enterTime: Long = 0,
    var expiresAt: Long = 0,
    var dissolveReason: String? = null
) {
    var premium: Int = 0

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

    abstract fun getText() : String

    abstract fun calculatePermium()

}