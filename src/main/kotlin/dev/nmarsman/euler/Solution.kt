package dev.nmarsman.euler

import dev.nmarsman.euler.solutions.EvenFibonacciNumbers
import dev.nmarsman.euler.solutions.MultiplesOfThreeAndFive
import kotlin.reflect.KClass
import kotlin.system.measureNanoTime

interface Solution: () -> Number?
{
    val identifier: Int
    val title: String
    val description: String

    companion object
    {
        fun run(solution: KClass<out Solution>, iterations: Int = 10)
        {
            val instance = solution.objectInstance
                ?: throw IllegalStateException("Solution '${solution.simpleName}' constructor can't be called.")

            println("Problem ${instance.identifier}\n" +
                    "${instance.title}:\n\n" +
                    "-".repeat(50) + "\n\n" +
                    "${instance.description}\n\n" +
                    "-".repeat(50) + "\n")

            measureNanoTime { println("Answer: ${instance.invoke() ?: "Unresolved"}\n") }
                .also { println("Time: ${"%.4f".format(it / 1000000f)}ms (first run)") }

            var average = 0L
            (0 .. iterations).forEach { average += measureNanoTime { instance.invoke() } }
                .also { println("      ${"%.4f".format((average / iterations) / 1000000f)}ms ($iterations iteration avg.)") }
        }

        fun run(solutions: List<KClass<out Solution>>, iterations: Int = 10)
            = solutions.forEach { run(it, iterations).also { println("\n" + "-".repeat(50) + "\n") } }
    }
}

fun main() = Solution.run(listOf(
    MultiplesOfThreeAndFive::class,
    EvenFibonacciNumbers::class
))