package ru.craftcoderr.tcpp.insproject

abstract class ContractState(protected var context: Contract) {

    abstract fun enter()
    abstract fun cancel()
    abstract fun dissolve(reason: String)
    abstract fun complete()

}