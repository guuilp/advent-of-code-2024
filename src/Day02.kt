fun main() {
    fun List<Int>.isReportSafe(): Boolean {
        val differences = this.zipWithNext { a, b -> a - b }

        val allPositiveNumbers = differences.count { it in 1..3 }
        val allNegativeNumbers = differences.count { it in -3..-1 }
        val total = differences.count()

        return allPositiveNumbers == total || allNegativeNumbers == total
    }

    fun part1(input: List<String>): Int {
        val reportList = input.map {
            it.split(" ").map { it.toInt() }
        }

        return reportList.count { it.isReportSafe() }
    }

    fun part2(input: List<String>): Int {
        val reportList = input.map {
            it.split(" ").map { it.toInt() }
        }

        var totalSafeReports = 0
        reportList.forEach { differences ->
            for (index in 0..differences.lastIndex) {
                val isReportSafe = differences.toMutableList().apply { removeAt(index) }.isReportSafe()

                if (isReportSafe) {
                    totalSafeReports++
                    break
                }
            }
        }

        return totalSafeReports
    }

    check(part1(readInput("Day02_test")) == 326)
    check(part2(readInput("Day02_test")) == 381)
}
