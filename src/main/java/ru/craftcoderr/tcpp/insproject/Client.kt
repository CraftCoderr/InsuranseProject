package ru.craftcoderr.tcpp.insproject

import java.util.*

class Client(
    var name: String,
    var documentId: String,
    var email: String,
    val contracts: MutableList<Contract> = ArrayList(),
    var blocked: Boolean = false
) {

    fun addContract(contract: Contract) {
        contracts.add(contract)
    }

    fun persist() {

    }
}