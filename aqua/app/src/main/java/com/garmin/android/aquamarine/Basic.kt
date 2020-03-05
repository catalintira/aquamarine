package com.garmin.android.aquamarine

// Exercise 1

open class Account(var balance: Float) {

    open fun withdraw(sumToWithdraw: Float) {
        balance -= sumToWithdraw
    }

    fun deposit(sumToDeposit: Float) {
        balance += sumToDeposit
    }
}

class SavingAccount(balance: Float) : Account(balance) {

    override fun withdraw(sumToWithdraw: Float) {
        if (sumToWithdraw > balance) {
            throw IllegalArgumentException()
        }

        super.withdraw(sumToWithdraw)
    }
}

// Exercise 2

//      N
//  W       E
//      S

fun getCardinalDirections(angle: Int): String {
    return when (angle) {
        in 45..134 -> "E"
        in 135..224 -> "S"
        in 225..314 -> "W"
        else -> "N"
    }
}

// Exercise 3

val vocals = listOf('a', 'e', 'i', 'o', 'u')

fun getVocalsCount(input: String): Int {
    var toReturn = 0

    input.forEach {
        if (vocals.contains(it)) ++toReturn
    }

    return toReturn
}

// Exercise 4 A

class RectangularShape(var x: Int, var y: Int, var with: Int, var height: Int, var color: Int) {
    fun measure() {}
    fun render() {}
}

fun validateShape(shape: RectangularShape): Boolean {
    return when {
        shape.x < 0 || shape.y < 0 -> {
            print("invalid position"); false
        }
        shape.with > 1024 || shape.height > 1024 -> {
            print("shape too big"); false
        }
        shape.color < 0 || shape.color > 0xFFFFFF -> {
            print("invalid color"); false
        }
        else -> true
    }
}

// Exercise 4 B

fun initShape(shape: RectangularShape?) {
    shape?.apply {
        x = 10
        y = 20
        with = 100
        height = 200
        color = 0xFF0066
    } ?: throw IllegalArgumentException()
}

// Exercise 4 C

fun drawShape(shape: RectangularShape?) {
    shape?.also { validateShape(it) }
        ?.also { it.measure() }
        ?.also { it.render() }
}

// Exercise 5

val data = listOf(4, 6, 34, 9, 2, 4, 7)

fun solveExercise5() {

    // A

    print(data)

    // B

    print(data.reversed())

    // C

    print(data.distinct())

    // D

    print(data.subList(0, 3))

    // E

    val min: Int? = data.min()
    if (min != null && min >= 0) print(data)

    // F

    print(data.map { it * it })

    // G

    print(data.filter { it % 2 == 0 })

    // H

    data.forEachIndexed { i, v -> if (v % 2 == 0) print(i) }

    // I

    fun isPrime(number: Int): Boolean {
        when (number) {
            in 0..1 -> return false
            2 -> return true
            else -> {
                if(number % 2 == 0) return false
                for (i in 3 until number step 2) {
                    if(number % i == 0)
                        return false
                }
            }
        }
        return true
    }

    print( data.filter { isPrime(it) } )

    // J

    data.last { isPrime(it) }
}

