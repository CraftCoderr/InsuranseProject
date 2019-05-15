package ru.craftcoderr.tcpp.insproject

interface ClientRepository {

    fun addClient(client: Client)

    fun addContract(client: Client, contract: Contract)

    fun getClient(documentId: String) : Client

}