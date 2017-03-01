package com.fruedacode.kata.tdd


class  PrimeFactorsGenerator{
    fun generate(number:Int): Collection<Int>{

        if(number > 1){
            return getFactors(number).filter { factor -> isPrimeNumber(factor) }
        }

        return listOf()
    }

    fun getFactors(number:Int): Collection<Int> {
        var factors = mutableListOf<Int>()
        var n = number
        var candidate = 2

        while(n > 1 && candidate < n){
            if(n % candidate == 0){
                factors.add(candidate)
                n /= 2
            }else{
                candidate++
            }
        }
        return factors;
    }

    fun isPrimeNumber(number: Int): Boolean{
        if(number > 1){
            return getFactors(number).size == 0
        }
        return false
    }

}

