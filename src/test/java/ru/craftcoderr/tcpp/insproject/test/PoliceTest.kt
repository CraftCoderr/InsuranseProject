package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.PoliceService
import ru.craftcoderr.tcpp.insproject.core.Car
import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.contract.CarInsContract
import ru.craftcoderr.tcpp.insproject.core.contract.Contract

class PoliceTest {

    companion object {
        lateinit var service : PoliceService

        lateinit var clientRepository: ClientRepository
        lateinit var client: Client
        lateinit var contract: Contract

        const val vin = "SHBF21742BF624Bf"
        const val regNumber = "a123бв92"

        @BeforeAll
        @JvmStatic
        fun init() {
            client = Client("Test", "123456", "test@mail.com")
            contract = CarInsContract(client,
                System.currentTimeMillis() + 1000 * 100,
                Car("testModel", 2012, regNumber, 140, vin)
            )
            client.addContract(contract)
            clientRepository = mock {
                whenever(mock.getClient("123456")).thenReturn(client)
            }
            service = PoliceService(clientRepository)
        }
    }

    @Test
    fun test_ContractEnterCreated() {
        assertTrue(service.checkCarPolicy("123456", regNumber, vin))
    }

}