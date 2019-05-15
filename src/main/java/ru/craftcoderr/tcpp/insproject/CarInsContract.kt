package ru.craftcoderr.tcpp.insproject

class CarInsContract(
    client: Client,
    state: ContractState,
    flag: StateFlag,
    enterTime: Long,
    expiresAt: Long,
    dissolveReason: String?,
    val car: Car
) : Contract(client, state, flag, enterTime, expiresAt, dissolveReason) {

    override fun getText(): String {
        return "Страховой договор на автомобиль ${car.model} с номером ${car.regNumber}. Сумма страховой премии $premium"
    }

    override fun calculatePermium() {
        premium = car.power * PREMIUM_COEFFICIENT
    }

    companion object {
        private const val PREMIUM_COEFFICIENT = 20
    }


}