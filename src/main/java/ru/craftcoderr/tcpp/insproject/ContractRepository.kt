package ru.craftcoderr.tcpp.insproject

import ru.craftcoderr.tcpp.insproject.core.contract.Contract

interface ContractRepository {

    fun addContract(contract: Contract)

}