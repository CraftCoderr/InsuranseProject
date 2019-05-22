package ru.craftcoderr.tcpp.insproject.test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import ru.craftcoderr.tcpp.insproject.ClientRepository
import ru.craftcoderr.tcpp.insproject.ContractRepository
import ru.craftcoderr.tcpp.insproject.OpertorService
import ru.craftcoderr.tcpp.insproject.core.Client

class BanClientTest {

    companion object {
        lateinit var service : OpertorService

        lateinit var clientRepository: ClientRepository
        lateinit var contractRepository: ContractRepository
        lateinit var client: Client
        const val id = "123456"

        @BeforeAll
        @JvmStatic
        fun init() {
            client = Client("Test", id, "test@mail.com")
            clientRepository = mock {
                whenever(mock.getClient(id)).thenReturn(client)
            }
            contractRepository = mock()
            service = OpertorService(clientRepository, contractRepository)
        }
    }

    @Test
    fun BanClient() {
        service.banClient(id)
        assertTrue(client.blocked)
    }

    @Test
    fun PardonClient() {
        service.pardonClient(id)
        assertFalse(client.blocked)
    }

}