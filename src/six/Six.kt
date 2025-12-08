package six

import java.io.File

fun main() {
    val inputFile = File("src/six/input.txt")

    val matrix: MutableList<List<Int>> = mutableListOf()
    var operators: List<Char> = mutableListOf()
    var password = 0L

    inputFile.forEachLine { line ->
        val trimmed = line.trim()
        val values = trimmed.split(" ").filter {
            it.isNotBlank()
        }

        if (trimmed.isNotEmpty() && trimmed.first().isDigit()) {
            val numbers = values.map { it.toInt() }
            matrix.add(numbers)
        } else {
            operators = values.map { it.single() }
        }
    }

    val transposedMatrix = matrix[0].indices.map { col ->
        matrix.map { row -> row[col] }
    }

    for (row in 0..<transposedMatrix.count()) {
        var count = transposedMatrix[row][0].toLong()

        for (col in 0..<transposedMatrix[row].count()) {
            if(col < transposedMatrix[row].count() -1) {
                when (operators[row]) {
                    '*' -> count *= transposedMatrix[row][col + 1].toLong()
                    '+' -> count += transposedMatrix[row][col + 1].toLong()
                }
            }
        }
        password += count
    }

    println("The password is $password")
}