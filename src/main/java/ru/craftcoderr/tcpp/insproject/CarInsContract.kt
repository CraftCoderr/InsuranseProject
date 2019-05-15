package ru.craftcoderr.tcpp.insproject

class CarInsContract(
    client: Client,
    expiresAt: Long,
    val car: Car,
    flag: StateFlag = StateFlag.CREATED,
    enterTime: Long = 0,
    dissolveReason: String? = null
    ) : Contract(client, expiresAt, flag, enterTime, dissolveReason) {

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