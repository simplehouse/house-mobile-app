package io.devmartynov.house.app.helpers

import java.text.SimpleDateFormat
import java.util.*

/**
 * Утилиты
 */
object Utils {
    /**
     * Переводит строковое представление даты во временную метку
     * Строка ---> Время
     * "2022-12-04 11:29:22" ---> 1231111123
     *
     * @param date дата в виде строки
     * @param pattern формат строковой даты
     */
    fun getTimeFromStringDate(date: String, pattern: String = "yyyy-MM-dd HH:mm:ss"): Long {
        return SimpleDateFormat(pattern, Locale.UK)
            .parse(date)
            ?.time ?: 0
    }

    /**
     * Переводит временную метку в строковое представление даты
     * Время ---> Строка
     * 1231111123 ---> "2022-12-04 11:29:22"
     *
     * @param time временная метка
     * @param pattern формат для строкового представления даты
     */
    fun getStringDateFromTime(time: Long, pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
        return SimpleDateFormat(pattern, Locale.UK)
            .format(time)
    }

    /**
     * Переводит строковое представление даты в другой строковой формат представления даты
     * Строка ---> Строка
     * "2022-12-04 11:29:22" ---> "12.04.2022"
     *
     * @param date строковое представление даты
     * @param patternFrom из какого форматы даты
     * @param patternTo в какой формат даты
     */
    fun formatDateString(
        date: String,
        patternFrom: String = "yyyy-MM-dd HH:mm:ss",
        patternTo: String = "dd.MM.yyyy",
    ): String {
        val time = getTimeFromStringDate(date, patternFrom)
        return getStringDateFromTime(time, patternTo)
    }
}