package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.ContractRepository
import ru.craftcoderr.tcpp.insproject.OpertorService
import ru.craftcoderr.tcpp.insproject.core.Client

class OperatorTest {

    lateinit var service : OpertorService
    lateinit var clientRepository: ClientRepository
    lateinit var contractRepository: ContractRepository

    @BeforeEach
    fun init() {
        clientRepository = mock()
        contractRepository = mock()
        service = OpertorService(clientRepository, contractRepository)
    }

    @Test
    fun test_addClient() {
        var client = Client("Test", "123456", "test@mail.com")
        service.addClient("Test", "123456", "test@mail.com")
        verify(clientRepository).addClient(client)
    }

}