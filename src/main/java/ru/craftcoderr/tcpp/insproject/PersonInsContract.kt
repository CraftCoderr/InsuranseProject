package ru.craftcoderr.tcpp.insproject

class PersonInsContract(
    client: Client,
    state: ContractState,
    flag: StateFlag,
    enterTime: Long,
    expiresAt: Long,
    dissolveReason: String?,
    val person: Person
) : Contract(client, state, flag, enterTime, expiresAt, dissolveReason) {

    override fun getText(): String {
        return "Договор страхования жизни. Сумма премии: $premium."
    }

    override fun calculatePermium() {
        premium = 1 / person.age * AGE_COEFFICIENT * PRICE_COEFFICIENT
    }

    companion object {
        private const val AGE_COEFFICIENT = 18
        private const val PRICE_COEFFICIENT = 100
    }

}