package com.garmin.android.aquamarine

// Exercise 1

open class Account(var balance: Float) {

    open fun withdraw(sumToWithdraw : Float) {
        balance -= sumToWithdraw
    }

    fun deposit(sumToDeposit : Float) {
        balance += sumToDeposit
    }
}

class SavingAccount(balance: Float) : Account(balance) {

    override fun withdraw(sumToWithdraw : Float) {
        if(sumToWithdraw > balance) {
            throw IllegalArgumentException()
        }

        super.withdraw(sumToWithdraw)
    }
}

// Exercise 2

//      N
//  W       E
//      S

fun getCardinalDirections(angle : Int) : String {
    return when (angle) {
        in 45..134 -> "E"
        in 135..224 -> "S"
        in 225..314 -> "W"
        else -> "N"
    }
}

// Exercise 3

val vocals = listOf('a', 'e', 'i', 'o', 'u')

fun getVocalsCount(input : String) : Int {
    var toReturn = 0

    input.forEach {
        if (vocals.contains(it)) ++toReturn
    }

    return toReturn
}
