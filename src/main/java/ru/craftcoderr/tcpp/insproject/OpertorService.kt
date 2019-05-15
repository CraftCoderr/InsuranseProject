package ru.craftcoderr.tcpp.insproject

class OpertorService(private val clientRepository: ClientRepository) {

    fun addClient(name: String, documentId: String, email: String) {
        var client = Client(name, documentId, email)
        client.persist()
    }

    fun createCarInsContract(documentId: String, expiresAt: Long, car: Car) {
        val client = clientRepository.getClient(documentId)
        addContract(client, CarInsContract(client, expiresAt, car))
    }

    fun createPersonInsContract(documentId: String, premium: Int, expiresAt: Long, person: Person) {
        val client = clientRepository.getClient(documentId)
        addContract(client, PersonInsContract(client, expiresAt, person))
    }

    fun createPropertyInsContract(documentId: String, expiresAt: Long, property: Property) {
        val client = clientRepository.getClient(documentId)
        addContract(client, PropertyInsContract(client, expiresAt, property))
    }

    private fun addContract(client: Client, contract: Contract) {
        contract.calculatePermium()
        contract.persist()
        client.addContract(contract)
        clientRepository.addContract(client, contract)
    }

}