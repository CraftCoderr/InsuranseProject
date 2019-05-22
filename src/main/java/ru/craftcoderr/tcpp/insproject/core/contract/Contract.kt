package ru.craftcoderr.tcpp.insproject.core.contract

import ru.craftcoderr.tcpp.insproject.core.*
import ru.craftcoderr.tcpp.insproject.core.contract.state.*

abstract class Contract(
    val client: Client,
    var expiresAt: Long,
    var flag: StateFlag = StateFlag.CREATED,
    var enterTime: Long = 0,
    var dissolveReason: String? = null
) {

    var premium: Int = 0
    var state: ContractState = when(flag) {
        StateFlag.CREATED -> CreatedState(this)
        StateFlag.ACTIVE -> ActiveState(this)
        StateFlag.CANCELLED -> CancelledState(
            this
        )
        StateFlag.COMPLETED -> CompletedState(
            this
        )
        StateFlag.DISSOLVED -> DissolvedState(
            this
        )
    }

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