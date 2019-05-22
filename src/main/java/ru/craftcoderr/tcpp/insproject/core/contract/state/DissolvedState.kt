package ru.craftcoderr.tcpp.insproject.core.contract.state

import ru.craftcoderr.tcpp.insproject.core.contract.Contract
import java.lang.IllegalStateException

class DissolvedState(context: Contract) : ContractState(context) {

    override fun enter() {
        throw IllegalStateException("Can't enter to DISSOLVED contract")
    }

    override fun cancel() {
        throw IllegalStateException("Can't cancel DISSOLVED contract")
    }

    override fun dissolve(reason: String) {
        throw IllegalStateException("Contract already dissolved")
    }

    override fun complete() {
        throw IllegalStateException("Can't complete DISSOLVED contract")
    }

}