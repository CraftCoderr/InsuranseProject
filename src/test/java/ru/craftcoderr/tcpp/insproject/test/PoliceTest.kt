package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertFalse
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

        const val vin1 = "SHBF21742BF624Bf"
        const val regNumber1 = "a123бв92"
        const val vin2 = "VIN2JHF437HFG"
        const val regNumber2 = "a999aa99"

        @BeforeAll
        @JvmStatic
        fun init() {
            client = Client("Test", "123456", "test@mail.com")
            var contract = CarInsContract(client,
                System.currentTimeMillis() + 1000 * 100,
                Car("testModel", 2012, regNumber1, 140, vin1),
                id = "c1"
            )
            client.addContract(contract)
            contract = CarInsContract(client,
                System.currentTimeMillis() - 1000,
                Car("anothermodel", 2000, regNumber2, 90, vin2),
                id = "c2"
            )
            client.addContract(contract)
            clientRepository = mock {
                whenever(mock.getClient("123456")).thenReturn(client)
            }
            service = PoliceService(clientRepository)
        }
    }

    @Test
    fun CheckActiveCarPolicy() {
        assertTrue(service.checkCarPolicy("123456", regNumber1, vin1))
    }

    @Test
    fun CheckExpiredCarPolicy() {
        assertFalse(service.checkCarPolicy("123456", regNumber2, vin2))
    }

}