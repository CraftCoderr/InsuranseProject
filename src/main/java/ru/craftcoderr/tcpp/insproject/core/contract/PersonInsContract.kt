package ru.craftcoderr.tcpp.insproject.core.contract

import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.Person
import ru.craftcoderr.tcpp.insproject.core.StateFlag

class PersonInsContract(
    client: Client,
    expiresAt: Long,
    val person: Person,
    id: String = "",
    flag: StateFlag = StateFlag.CREATED,
    enterTime: Long = 0,
    dissolveReason: String? = null
) : Contract(client, id, expiresAt, flag, enterTime, dissolveReason) {

    override fun getText(): String {
        return "Договор страхования жизни. Сумма премии: $premium."
    }

    override fun calculatePermium() {
        premium = (((1.0f / person.age) * AGE_COEFFICIENT * PRICE_COEFFICIENT).toInt())
    }

    companion object {
        private const val AGE_COEFFICIENT = 18
        private const val PRICE_COEFFICIENT = 100
    }

}