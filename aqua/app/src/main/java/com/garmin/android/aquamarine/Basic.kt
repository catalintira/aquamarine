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