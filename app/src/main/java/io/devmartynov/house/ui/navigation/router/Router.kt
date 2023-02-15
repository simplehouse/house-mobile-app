package io.devmartynov.house.ui.navigation.router

import io.devmartynov.house.domain.model.MeterReadingEntity

interface Router {
    fun navigateToProfile()

    fun navigateToSignIn()

    fun navigateToMeterReadings()

    fun navigateToStatistics()

    fun navigateToPasswordRecovery()

    fun navigateToAddMeterReading(service: Int)

    fun navigateToMeterReading(meterReading: MeterReadingEntity)

    fun navigateToInvoices()
}