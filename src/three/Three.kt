package three

import java.io.File

fun main() {
    val inputFile = File("src/three/input.txt")

    val banks = mutableListOf<String>()
    inputFile.forEachLine {
        banks.add(it)
    }

    var totalJoltage = 0

    for (bank in banks) {
        val series = bank.toList()
        val firstDigit = bank.dropLast(1).max()
        val remainderOfSeries = bank.slice(bank.indexOf(firstDigit)+1..<series.size)
        val secondDigit = remainderOfSeries.max()

        totalJoltage += "$firstDigit$secondDigit".toInt()
    }


    println("The password is ${totalJoltage}")
}