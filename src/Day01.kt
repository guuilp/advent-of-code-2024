import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()
        input.forEach { line ->
            val split = line.split("   ")
            firstList.add(split[0].toInt())
            secondList.add(split[1].toInt())
        }

        firstList.sort()
        secondList.sort()

        var totalDistance = 0
        firstList.forEachIndexed { index, i ->
            val distance = i - secondList[index]
            totalDistance += abs(distance)
        }

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()
        input.forEach { line ->
            val split = line.split("   ")
            firstList.add(split[0].toInt())
            secondList.add(split[1].toInt())
        }

        firstList.sort()
        secondList.sort()

        var similarityScore = 0
        firstList.forEachIndexed { index, number ->
            val count = secondList.count { i -> i == number }
            similarityScore += (number * count)
        }

        return similarityScore
    }

    check(part1(readInput("Day01_test")) == 1580061)
    check(part2(readInput("Day01_test")) == 23046913)
}
