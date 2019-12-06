package dev.nmarsman.euler.solutions

import dev.nmarsman.euler.Solution
import dev.nmarsman.euler.utils.Utils
import dev.nmarsman.euler.utils.isPalindrome

object LargestPalindromeProduct: Solution
{
    override val identifier: Int = 4
    override val title: String = "Largest palindrome product"

    override val description: String
        = "A palindromic number reads the same both ways. " +
          "The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n\n" +
          "Find the largest palindrome made from the product of two 3-digit numbers."

    override fun invoke(): Int
    {
        var palindrome = 1

        var first = 999
        while (first >= 100)
        {
            var second = 999
            while (second >= first)
            {
                if (first * second <= palindrome)
                    break

                palindrome = (first * second).takeIf { it.isPalindrome } ?: palindrome
                second--
            }

            first--
        }

        return palindrome
    }
}

fun main() = Solution.run(LargestPalindromeProduct::class)