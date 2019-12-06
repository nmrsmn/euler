package dev.nmarsman.euler.solutions

import dev.nmarsman.euler.Solution

object MultiplesOfThreeAndFive: Solution
{
    override val identifier: Int = 1
    override val title: String = "Multiples of 3 and 5"

    override val description: String
        = "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. " +
          "The sum of these multiples is 23.\n\n" +
          "Find the sum of all the multiples of 3 or 5 below 1000."

    override fun invoke(): Int
        = (1 until 1000).filter { it % 3 == 0 || it % 5 == 0 }.sum()
}

fun main() = Solution.run(MultiplesOfThreeAndFive::class)