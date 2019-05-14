package ru.craftcoderr.tcpp.insproject

import java.lang.IllegalStateException

class CreatedState(context: Contract) : ContractState(context) {

    override fun enter() {
        context.flag = StateFlag.ACTIVE
        context.enterTime = System.currentTimeMillis()
        context.state = ActiveState(context)
    }

    override fun cancel() {
        context.flag = StateFlag.CANCELLED
        context.state = CancelledState(context)
    }

    override fun dissolve(reason: String) {
        throw IllegalStateException("Can't dissolve not ACTIVE contract")
    }

    override fun complete() {
        throw IllegalStateException("Can't complete contract in CREATED state")
    }


}