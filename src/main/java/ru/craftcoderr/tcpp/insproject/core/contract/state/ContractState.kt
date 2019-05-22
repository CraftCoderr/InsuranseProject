package ru.craftcoderr.tcpp.insproject.core.contract.state

import ru.craftcoderr.tcpp.insproject.core.contract.Contract

abstract class ContractState(protected var context: Contract) {

    abstract fun enter()
    abstract fun cancel()
    abstract fun dissolve(reason: String)
    abstract fun complete()

}