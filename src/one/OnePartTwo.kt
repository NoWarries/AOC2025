package one

import java.io.File
import java.util.stream.Collectors
import java.util.stream.IntStream


fun main() {
    val inputFile = File("src/one/input.txt")

    // The dial has numbers 0 through 99 in order
    val dial = IntStream.rangeClosed(0, 99).boxed().collect(Collectors.toList())

    // The dial starts by pointing at 50 (index)
    var dialPosition = 50

    // Track the total times the dial is pointing at exactly 0
    var timesAtZero = 0

    inputFile.forEachLine {
        val direction = it[0]
        val amount: Int = it.drop(1).toInt()

        val step = if (direction == 'R') 1 else -1

        repeat(amount) {
            dialPosition = (dialPosition + step).mod(dial.size)
            if (dialPosition == 0) timesAtZero++
        }
    }

    println("The password is $timesAtZero")
}