package ru.craftcoderr.tcpp.insproject.core.contract

import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.Property
import ru.craftcoderr.tcpp.insproject.core.StateFlag

class PropertyInsContract(
    client: Client,
    expiresAt: Long,
    val property: Property,
    id: String = "",
    flag: StateFlag = StateFlag.CREATED,
    enterTime: Long = 0,
    dissolveReason: String? = null
) : Contract(client, id, expiresAt, flag, enterTime, dissolveReason) {

    override fun getText(): String {
        return "Договор страхования недвижимого имущества. Сумма премии: $premium."
    }

    override fun calculatePermium() {
        premium = (property.value * PREMIUM_CONEFFICIENT).toInt()
    }

    companion object {
        private const val PREMIUM_CONEFFICIENT = 0.01
    }

}