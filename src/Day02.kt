fun main() {
    fun part1(input: List<String>): Int {
        var safeCount = 0
        input.forEach { line ->
            val levels = line.split(" ").map { it.toInt() }
            val allDifferences = buildList<Int> {
                levels.forEachIndexed { index, level ->
                    if (index != levels.lastIndex) {
                        add(level - levels[index + 1])
                    }
                }
            }

            val safe = if (levels[0] - levels[1] > 0) {
                allDifferences.all { i -> (i > 0 && i < 4) }
            } else {
                allDifferences.all { i -> (i < 0 && i > -4) }
            }

            if (safe) safeCount++
        }
        return safeCount
    }

    fun part2(input: List<String>): Int {
        var safeCount = 0
        input.forEach { line ->
            val levels = line.split(" ").map { it.toInt() }
            println(levels.zipWithNext { a, b -> a - b})
//            val allDifferences = buildList<Int> {
//                levels.forEachIndexed { index, level ->
//                    if (index != levels.lastIndex) {
//                        add(level - levels[index + 1])
//                    }
//                }
//            }
//
//            val differenceSize = if (levels[0] - levels[1] > 0) {
//                allDifferences.filterNot { i -> (i > 0 && i < 4) }.size
//            } else {
//                allDifferences.filterNot { i -> (i < 0 && i > -4) }.size
//            }
//
//            if (differenceSize == 0 || differenceSize == 1) safeCount++
        }
        return safeCount
    }

    check(part1(readInput("Day02_test")) == 326)
    println(part2(readInput("Day02_test")))
}
