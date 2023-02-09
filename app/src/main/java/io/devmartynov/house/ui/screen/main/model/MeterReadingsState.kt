package io.devmartynov.house.ui.screen.main.model

/**
 * Состояние экрана показаний счетчиков
 *
 * @param gas состояние коммунальной услуги газ
 * @param water состояние коммунальной услуги вода
 * @param electricity состояние коммунальной услуги электричество
 */
data class MeterReadingsState(
    val gas: ServiceState = ServiceState(service = Service.GAS),
    val water: ServiceState = ServiceState(service = Service.WATER),
    val electricity: ServiceState = ServiceState(service = Service.ELECTRICITY)
) {
    /**
     * Получает состония коммунальной услуги по индексу
     */
    fun get(index: Int): ServiceState {
        val serviceName = Service.values()[index]

        return when (serviceName) {
            gas.service -> gas
            water.service -> water
            electricity.service -> electricity
            else -> gas
        }
    }

    /**
     * Получает состония коммунальной услуги по названию услуги
     */
    fun get(service: Service): ServiceState {
        return when (service) {
            gas.service -> gas
            water.service -> water
            electricity.service -> electricity
            else -> gas
        }
    }
}


