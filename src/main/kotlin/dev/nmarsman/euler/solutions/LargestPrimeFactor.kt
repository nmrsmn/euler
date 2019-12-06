package dev.nmarsman.euler.solutions

import dev.nmarsman.euler.Solution

object LargestPrimeFactor: Solution
{
    override val identifier: Int = 3
    override val title: String = "Largest prime factor"

    override val description: String
        = "The prime factors of 13195 are 5, 7, 13 and 29.\n\n" +
          "What is the largest prime factor of the number 600851475143?"

    override fun invoke(): Long
    {
        var number = 600851475143L
        var prime = 2L

        while (prime < number / prime)
        {
            while (number % prime == 0L)
                number /= prime
            prime++
        }

        return number
    }
}

fun main() = Solution.run(LargestPrimeFactor::class)