package dev.nmarsman.euler.utils

val Int.isPalindrome: Boolean
    get() = this == this.reversed

val Int.reversed: Int get()
{
    var input = this
    var output = 0

    while (input > 0)
    {
        output = 10 * output + input % 10
        input /= 10
    }

    return output
}