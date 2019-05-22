package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.ContractRepository
import ru.craftcoderr.tcpp.insproject.OpertorService
import ru.craftcoderr.tcpp.insproject.core.*

class CreateContractsTest {

    lateinit var service : OpertorService

    lateinit var client: Client
    lateinit var clientRepository: ClientRepository
    lateinit var contractRepository: ContractRepository

    @BeforeEach
    fun init() {
        client = Client("Test", "123456", "test@mail.com")
        clientRepository = mock {
            whenever(mock.getClient("123456")).thenReturn(client)
        }
        contractRepository = mock()
        service = OpertorService(clientRepository, contractRepository)
    }

    @Test
    fun CreateCarContract() {
        val contract = service.createCarInsContract(
            "123456",
            System.currentTimeMillis(),
            Car("testModel", 2012, "a123бв92", 140, "SHBF21742BF624Bf")
        )
        assertTrue(contract.premium > 0)
        verify(contractRepository).addContract(contract)
        verify(clientRepository).addContract(client, contract)
    }

    @Test
    fun CreatePersonContract() {
        val contract = service.createPersonInsContract(
            "123456",
            System.currentTimeMillis(),
            Person("Person", GenderType.MALE, 25, true)
        )
        assertTrue(contract.premium > 0)
        verify(contractRepository).addContract(contract)
        verify(clientRepository).addContract(client, contract)
    }


    @Test
    fun CreatePropertyContract() {
        val contract = service.createPropertyInsContract(
            "123456",
            System.currentTimeMillis(),
            Property(1000000, "address st., Moscow city")
        )
        assertTrue(contract.premium > 0)
        verify(contractRepository).addContract(contract)
        verify(clientRepository).addContract(client, contract)
    }

}