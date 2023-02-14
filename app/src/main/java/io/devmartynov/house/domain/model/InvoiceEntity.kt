package io.devmartynov.house.domain.model

/**
 * Квитанция
 *
 * @param id уникальный ключ
 * @param createTime дата создания квитанции
 * @param servicesData данные по поданным показаниями счетчиков
 */
data class InvoiceEntity(
    val id: Int,
    val createTime: String,
    val servicesData: List<ServiceInvoiceEntity>,
) {
    /**
     * Полная стоимость за все коммунальные услуги
     *
     * @return стоимость
     */
    fun getToPayAmount(): Float {
        return servicesData
            .sumOf { it.amountToPay.toDouble() }
            .toFloat()
    }
}
