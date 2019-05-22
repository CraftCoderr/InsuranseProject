package ru.craftcoderr.tcpp.insproject.core

import ru.craftcoderr.tcpp.insproject.core.contract.Contract
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