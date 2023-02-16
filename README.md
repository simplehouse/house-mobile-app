<div align="center">
    <p>
        <img src="https://github.com/simplehouse/house-mobile-app/blob/main/docs/images/ic_launcher.png" width="200">
    </p>

# Коммуналка

### Подавай показания счетчиков, просматривай историю показаний

[![Android](https://img.shields.io/badge/Android-grey?logo=android&style=flat)](https://www.android.com/)
[![AndroidAPI](https://img.shields.io/badge/API-25%2B-brightgreen.svg?style=flat)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.0-blue.svg?logo=kotlin)](https://kotlinlang.org)
[![JetpackCompose](https://img.shields.io/badge/Jetpack%20Compose-1.3.9-yellow)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/github/license/simplehouse/house-mobile-app?color=orange)](./LICENSE)
</div>

## Мотивация

### Проблема

Относительно недавно я понял, что уже совсем взрослый - я сам подаю показания счётчиков. Каждый месяц галерея в телефоне
пополняется несколькими снимками счётчиков. Я всегда думал, что это автоматизированный процесс. Посмотрел на счётчик,
ввел циферки в приложении или на сайте, нажал
кнопочку отправить и через какое-то время в почтовый ящик приходит квитанция.

Оказалось немного не так.

Как это сейчас у меня работает.

Есть многоквартирный дом, в котором я живу. За этим домом закреплена обслуживающая организация.
Каждый месяц мне нужно подавать показания счётчиков в эту организацию. Делать это необходимо через специального
человека. Среди жильцов дома выбирается представитель. Этот представитель получает показания счётчиков от жильцов дома,
что-то с ними делает, затем направляет их в обслуживающую организацию, а через какое-то время присылает PDF'ку с
квитанцией прямо в личные сообщения мессенджера. За такую работу представитель получает от обслуживающей организации
денежные средства.

<p style="margin-top: 60px; margin-bottom: 60px;" align="center">
    <img src="https://github.com/simplehouse/house-mobile-app/blob/main/docs/images/work_scheme.png">
</p>

Что же здесь не так?

Все так. Эта система - вполне рабочий вариант. Но это не значит, что такую систему нельзя улучшить.

Давай разберемся за что отвечает представитель.

Он:

- Принимает данные от жильцов(как правило, в виде фотографии)
- Подготавливает эти данные(как минимум выписывает данные из фотографии)
- Вносит эти данные в условный Exel, где по формулы выполняют всю нудную работу
- Направляет обработанные данные в обслуживающую организацию
- Направляет квитанции жильцам(по средствам сообщений в мессенджере)

Каждый из этих пунктов можно автоматизировать.

### Решение

Я предлагаю создать систему, т.е. набор программ которые автоматизируют конкретно этот процесс.
Это именно система. Мобильное приложение - кусочек этой системы.

<p style="margin-top: 60px; margin-bottom: 60px;" align="center">
    <img src="https://github.com/simplehouse/house-mobile-app/blob/main/docs/images/new_work_scheme.png">
</p>

Как приложение улучшит работу?

- Удобное внесение показаний. Здесь может быть все что угодно - числа, фотографии
- Своевременное информирование. Уведомления, напоминания в приложении
- Отсутствует человеческий фактор
- История показаний. Вам не нужно хранить пачку квитанций в квартире. Можно экспортировать их из приложения
- Статистика. Графическая информация воспринимается лучше, чем циферки
