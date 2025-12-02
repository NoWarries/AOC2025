package two

import java.io.File

fun main() {
    val inputFile = File("src/two/input.txt")

    val ranges = inputFile.readText().split(",")
    val regex = Regex("^(\\d+)\\1$")

    var invalidIdsSum = 0L

    for (range in ranges) {
        val ids = range.trim().split("-")
        val start = ids[0].toLong()
        val end = ids[1].toLong()

        for (value in start..end) {
            if (regex.matches(value.toString())) {
                invalidIdsSum += value
            }
        }
    }

    println("The password is $invalidIdsSum")
}
