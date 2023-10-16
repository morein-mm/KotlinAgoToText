import java.time.LocalDateTime

fun main() {
    println(agoToText(1_000_000_000))
}

fun agoToText(seconds: Int):String {
    return "был(а) " + when (seconds) {
        in 0..60 -> "только что"
        in 61..3600 -> {
            val result = (seconds / 60).toString() + " " + minutesToText(seconds / 60) + " назад"
            result
        }
        in 3601..86_400 -> {
            val result = (seconds / 3600).toString() + " " + hoursToText(seconds / 3600) + " назад"
            result
        }
        in 86_401..172_800 -> "вчера"
        in 172_801..345_600 -> "позавчера"
        else -> "давно"
    }
}

fun hoursToText(hours: Int):String {
    return when (hours) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        else -> "часов"
    }
}

fun minutesToText(minute: Int):String {
    return when (minute) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }
}