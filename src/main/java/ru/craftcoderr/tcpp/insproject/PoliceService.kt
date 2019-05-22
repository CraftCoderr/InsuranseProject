package ru.craftcoderr.tcpp.insproject

import ru.craftcoderr.tcpp.insproject.core.contract.CarInsContract

class PoliceService(private val clientRepository: ClientRepository) {

    fun checkCarPolicy(documentId: String, regNumber: String, vin: String) : Boolean {
        val client = clientRepository.getClient(documentId)
        val c = client.getContracts()
            .filter { c -> c is CarInsContract }
            .map { c -> c as CarInsContract}
            .firstOrNull { c -> c.car.regNumber.equals(regNumber) && c.car.vin.equals(vin) && !c.isExpired() }
        return c != null
    }

}