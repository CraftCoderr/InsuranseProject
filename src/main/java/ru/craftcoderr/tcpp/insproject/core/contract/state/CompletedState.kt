package ru.craftcoderr.tcpp.insproject.core.contract.state

import ru.craftcoderr.tcpp.insproject.core.contract.Contract
import java.lang.IllegalStateException

class CompletedState(context: Contract) : ContractState(context) {

    override fun enter() {
        throw IllegalStateException("Can't enter to COMPLETED contract")
    }

    override fun cancel() {
        throw IllegalStateException("Can't cancel COMPLETED contract")
    }

    override fun dissolve(reason: String) {
        throw IllegalStateException("Can't dissolve COMPLETED contract")
    }

    override fun complete() {
        throw IllegalStateException("Contract already COMPLETED")
    }
}