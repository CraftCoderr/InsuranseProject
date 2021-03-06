package ru.craftcoderr.tcpp.insproject.core.contract

import ru.craftcoderr.tcpp.insproject.core.Car
import ru.craftcoderr.tcpp.insproject.core.Client
import ru.craftcoderr.tcpp.insproject.core.StateFlag

class CarInsContract(
    client: Client,
    expiresAt: Long,
    val car: Car,
    id: String = "",
    flag: StateFlag = StateFlag.CREATED,
    enterTime: Long = 0,
    dissolveReason: String? = null
    ) : Contract(client, id, expiresAt, flag, enterTime, dissolveReason) {

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