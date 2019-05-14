package ru.craftcoderr.tcpp.insproject

import java.lang.IllegalStateException

class ActiveState(context: Contract) : ContractState(context) {

    override fun enter() {
        throw IllegalStateException("Can't enter to ACTIVE contract")
    }

    override fun cancel() {
        throw IllegalStateException("Can't cancel ACTIVE contract. Use Contract.dissolve(...)")
    }

    override fun dissolve(reason: String) {
        context.flag = StateFlag.DISSOLVED
        context.dissolveReason = reason
        context.state = DissolvedState(context)
    }

    override fun complete() {
        context.flag = StateFlag.COMPLETED
        context.state = CompletedState(context)
    }

}