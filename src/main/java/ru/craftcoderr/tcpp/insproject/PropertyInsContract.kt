package ru.craftcoderr.tcpp.insproject

class PropertyInsContract(
    client: Client,
    state: ContractState,
    flag: StateFlag,
    enterTime: Long,
    expiresAt: Long,
    dissolveReason: String?,
    val property: Property
) : Contract(client,  state, flag, enterTime, expiresAt, dissolveReason) {

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