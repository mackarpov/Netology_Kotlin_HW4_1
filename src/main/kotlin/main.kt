package ru.netology

fun main() {
    val seconds: Int = 61

    agoToText(seconds)
}

fun agoToText(seconds: Int) {

    val secondsInMinute: Int = 60
    val secondsInHour: Int = 3600
    val secondsInDay: Int = 86400
    var timeInMinutes: Int = 0
    var timeInHours: Int = 0

    when {
        seconds > 0 && seconds <= secondsInMinute -> println("был(а) только что")
        seconds > secondsInMinute && seconds <= secondsInHour -> {
            timeInMinutes = seconds / secondsInMinute
            println("был(а) $timeInMinutes ${correctMinutesEnding(timeInMinutes)} назад")
        }
        seconds > secondsInHour && seconds <= secondsInDay -> {
            timeInHours = seconds / secondsInHour
            println("был(а) $timeInHours ${correctHoursEnding(timeInHours)} назад")
        }
        seconds > secondsInDay && seconds <= secondsInDay * 2 -> println("был(а) вчера")
        seconds > secondsInDay * 2 && seconds <= secondsInDay * 3 -> println("был(а) позавчера")
        seconds > secondsInDay * 3 -> println("был(а) давно")
    }
}

fun correctMinutesEnding(timeInMinutes: Int): String {
    var word: String = ""
    when {
        timeInMinutes % 10 == 1 && timeInMinutes != 11 -> word = "минуту"
        timeInMinutes % 10 == 2 && timeInMinutes != 12 -> word = "минуты"
        timeInMinutes % 10 == 3 && timeInMinutes != 13 -> word = "минуты"
        timeInMinutes % 10 == 4 && timeInMinutes != 14 -> word = "минуты"
        timeInMinutes % 10 == 5 -> word = "минут"
        timeInMinutes % 10 == 6 -> word = "минут"
        timeInMinutes % 10 == 7 -> word = "минут"
        timeInMinutes % 10 == 8 -> word = "минут"
        timeInMinutes % 10 == 9 -> word = "минут"
        timeInMinutes % 10 == 9 -> word = "минут"
        timeInMinutes >= 10 && timeInMinutes <= 14 -> word = "минут"
    }
    return word
}

fun correctHoursEnding(timeInHours: Int): String {
    var word: String = ""
    when (timeInHours) {
        1, 21 -> word = "час"
        2, 3, 4, 22, 23, 24 -> word = "часа"
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> word = "часов"
    }
    return word
}