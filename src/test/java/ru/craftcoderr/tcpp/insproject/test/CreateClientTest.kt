package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.ContractRepository
import ru.craftcoderr.tcpp.insproject.OpertorService

class CreateClientTest {

    companion object {
        lateinit var service : OpertorService
        lateinit var clientRepository: ClientRepository
        lateinit var contractRepository: ContractRepository

        @BeforeAll
        @JvmStatic
        fun init() {
            clientRepository = mock()
            contractRepository = mock()
            service = OpertorService(clientRepository, contractRepository)
        }
    }

    @Test
    fun CreateClient() {
        val client = service.addClient("Test", "123456", "test@mail.com")
        verify(clientRepository).addClient(client)
    }

}