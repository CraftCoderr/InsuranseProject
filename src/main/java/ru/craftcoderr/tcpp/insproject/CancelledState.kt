package ru.craftcoderr.tcpp.insproject

import java.lang.IllegalStateException

class CancelledState(context: Contract) : ContractState(context) {

    override fun enter() {
        throw IllegalStateException("Can't enter to CANCELLED contract")
    }

    override fun cancel() {
        throw IllegalStateException("Can't cancel CANCELLED contract")
    }

    override fun dissolve(reason: String) {
        throw IllegalStateException("Can't dissolve CANCELLED contract")
    }

    override fun complete() {
        throw IllegalStateException("Can't complete CANCELLED contract")
    }
}