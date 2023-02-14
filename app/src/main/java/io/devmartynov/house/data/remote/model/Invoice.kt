package io.devmartynov.house.data.remote.model

/**
 * Квитанция
 *
 * @param id уникальный ключ
 * @param createTime дата создания квитанции
 * @param servicesData данные по поданным показаниями счетчиков
 */
data class Invoice(
    val id: Int,
    val createTime: String,
    val servicesData: List<ServiceInvoice>,
)
