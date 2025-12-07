package five

import java.io.File

fun main() {
    val inputFile = File("src/five/input.txt")

    val freshIngredientIdRanges = mutableSetOf<Array<Long>>()
    val availableIngredientIds = mutableListOf<Long>()
    var totalFreshAvailableIngredients = 0


    inputFile.forEachLine {
        if (it.contains("-")) {
            val rangeMin = it.split("-")[0].toLong()
            val rangeMax = it.split("-")[1].toLong()
            freshIngredientIdRanges.add(arrayOf(rangeMin, rangeMax))
        } else if (it.isNotBlank()) {
            availableIngredientIds.add(it.toLong())
        }
    }

    for (id in availableIngredientIds) {
        if (freshIngredientIdRanges.any { id >= it[0] && id <= it[1] }) {
            totalFreshAvailableIngredients++
        }
    }

    println("The password is $totalFreshAvailableIngredients")
}
