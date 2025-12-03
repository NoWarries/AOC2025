package three

import java.io.File

fun main() {
    val inputFile = File("src/three/input.txt")

    val banks = mutableListOf<String>()
    inputFile.forEachLine {
        banks.add(it)
    }

    var totalJoltage = 0L

    val targetLength = 12

    for (bank in banks) {
        val result = mutableListOf<Number>()
        var currentLength = targetLength
        var series = bank

        for (_number in 1..targetLength) {
            for (i in 9 downTo 1) {
                val index = series.indexOf("$i")

                if (index == -1 || index > series.length - currentLength) {
                    continue
                }
                result.add(i)
                series = series.slice(series.indexOf("$i") + 1..<series.toList().size)
                currentLength -= 1
                break
            }
        }

        totalJoltage += result.joinToString("").toLong()
    }

    println("The password is $totalJoltage")
}