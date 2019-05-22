package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.ContractRepository
import ru.craftcoderr.tcpp.insproject.OpertorService
import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.Property
import ru.craftcoderr.tcpp.insproject.core.StateFlag
import ru.craftcoderr.tcpp.insproject.core.contract.Contract
import ru.craftcoderr.tcpp.insproject.core.contract.PropertyInsContract

class EnterContractTest {

    companion object {
        lateinit var service : OpertorService

        lateinit var clientRepository: ClientRepository
        lateinit var contractRepository: ContractRepository
        lateinit var client: Client
        lateinit var contract1: Contract

        @BeforeAll
        @JvmStatic
        fun init() {
            client = Client("Test", "123456", "test@mail.com")
            contract1 = PropertyInsContract(client,
                System.currentTimeMillis(),
                Property(1000000, "address st., Moscow city"),
                id = "c1"
            )
            client.addContract(contract1)
            val contract2 = PropertyInsContract(client,
                System.currentTimeMillis(),
                Property(200000, "address, SPB city"),
                id = "c2",
                flag = StateFlag.ACTIVE,
                enterTime = System.currentTimeMillis()
            )
            client.addContract(contract2)
            clientRepository = mock {
                whenever(mock.getClient("123456")).thenReturn(client)
            }
            contractRepository = mock()
            service = OpertorService(clientRepository, contractRepository)
        }
    }

    @Test
    fun test_ContractEnterCreated() {
        service.enterContract("123456", "c1")
        assertEquals(client.getContract("c1")!!.flag, StateFlag.ACTIVE)
        verify(contractRepository).updateContract(contract1)
    }

    @Test
    fun test_ContractEnterActive() {
        assertThrows(RuntimeException::class.java, {
            service.enterContract("123456", "c2")
        }, "Can't cancel ACTIVE contract. Use Contract.dissolve(...)")
    }

}