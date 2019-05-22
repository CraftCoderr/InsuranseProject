package ru.craftcoderr.tcpp.insproject.core

import ru.craftcoderr.tcpp.insproject.core.contract.Contract
import java.util.*

class Client(
    var name: String,
    var documentId: String,
    var email: String,
    val contracts: MutableMap<String, Contract> = HashMap(),
    var blocked: Boolean = false
) {

    fun addContract(contract: Contract) {
        contracts[contract.id] = contract
    }

    fun getContract(id: String): Contract? {
        return contracts[id]
    }

}