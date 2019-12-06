package dev.nmarsman.euler.utils

object Utils
{
    fun fibonacci() = sequence()
    {
        var terms = 0 to 1
        while (true)
        {
            yield(terms.first)
            terms = terms.second to terms.first + terms.second
        }
    }
}