package io.devmartynov.house.ui.navigation.router

interface Router {
    fun navigateToProfile()

    fun navigateToSignIn()

    fun navigateToMetersReading()

    fun navigateToStatistics()

    fun navigateToPasswordRecovery()

    fun navigateToAddMeterReading(service: Int)

    fun navigateToMeterReading(id: Int)
}