package four

import java.io.File

fun main() {
    val inputFile = File("src/four/input.txt")

    val grid: MutableList<MutableList<String>> = mutableListOf()

    inputFile.forEachLine { line ->
        grid.add(line.map { it.toString() }.toMutableList())
    }

    var accessibleRolls = 0

    grid.forEachIndexed { r, row ->
        row.forEachIndexed { c, value ->
            if (value != "@") return@forEachIndexed


            var adjacentRolls = 0

            for (rowIndex in (r - 1)..(r + 1)) {
                for (colIndex in (c - 1)..(c + 1)) {

                    if (rowIndex == r && colIndex == c) continue

                    if (rowIndex !in grid.indices) continue
                    if (colIndex !in grid[rowIndex].indices) continue

                    if (grid[rowIndex][colIndex] == "@") {
                        adjacentRolls++
                    }
                }
            }

            if (adjacentRolls < 4) accessibleRolls++
        }
    }

    println("The password is $accessibleRolls")
}