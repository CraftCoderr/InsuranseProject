package ru.craftcoderr.tcpp.insproject

import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.contract.Contract

interface ClientRepository {

    fun addClient(client: Client)

    fun addContract(client: Client, contract: Contract)

    fun getClient(documentId: String) : Client

}