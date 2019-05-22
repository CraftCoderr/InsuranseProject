package ru.craftcoderr.tcpp.insproject

import ru.craftcoderr.tcpp.insproject.core.*
import ru.craftcoderr.tcpp.insproject.core.contract.CarInsContract
import ru.craftcoderr.tcpp.insproject.core.contract.Contract
import ru.craftcoderr.tcpp.insproject.core.contract.PersonInsContract
import ru.craftcoderr.tcpp.insproject.core.contract.PropertyInsContract

class OpertorService(private val clientRepository: ClientRepository, private val contractRepository: ContractRepository) {

    fun addClient(name: String, documentId: String, email: String) : Client {
        var client = Client(name, documentId, email)
        clientRepository.addClient(client)
        return client
    }

    fun createCarInsContract(documentId: String, expiresAt: Long, car: Car) : CarInsContract {
        val client = clientRepository.getClient(documentId)
        val contract = CarInsContract(client, expiresAt, car)
        addContract(client, contract)
        return contract
    }

    fun createPersonInsContract(documentId: String, expiresAt: Long, person: Person): PersonInsContract {
        val client = clientRepository.getClient(documentId)
        val contract = PersonInsContract(client, expiresAt, person)
        addContract(client, contract)
        return contract
    }

    fun createPropertyInsContract(documentId: String, expiresAt: Long, property: Property): PropertyInsContract {
        val client = clientRepository.getClient(documentId)
        val contract = PropertyInsContract(client, expiresAt, property)
        addContract(client, contract)
        return contract
    }

    fun enterContract(documentId: String, contractId: String) {
        val client = clientRepository.getClient(documentId)
        val contract = client.getContract(contractId)
        contract?.let {
            it.enter()
            contractRepository.updateContract(it)
        }
    }

    private fun addContract(client: Client, contract: Contract) {
        contract.calculatePermium()
        contractRepository.addContract(contract)
        client.addContract(contract)
        clientRepository.addContract(client, contract)
    }

}