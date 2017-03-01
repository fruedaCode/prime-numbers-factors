package com.fruedacode.kata.tdd

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.IntStream

class PrimeNumberFactorsSpec extends Specification{

    private PrimeFactorsGenerator generator

    def setup() {
        given:"a new PrimeFactorGenerator"
        generator = new PrimeFactorsGenerator()
    }

    def "has 0 prime number factors"() {
        when:"input is 0"
        then: "result will be an empty list"
        generator.generate(0) == []
    }

    def "has 1 prime number factors"() {
        when:"input is 1"
        then: "result will be an empty list"
        generator.generate(1) == []
    }

    def "has 2 prime number factors"() {
        when:"input is 0"
        then: "result will be an empty list"
        generator.generate(2) == []
    }

    def "has 4 prime number factors"() {
        when:"input is 4"
        then: "result will be a collection with the element 2"
        generator.generate(4) == [2]
    }

    def "has 23 prime number factors"() {
        when:"input is 23"
        then: "result will be a collection with the element 2"
        generator.generate(23) == Collections.emptyList()
    }

    def "has 25 prime number factors"() {
        when:"input is 25"
        then: "result will be a collection with the element 2"
        generator.generate(25) == [5]
    }

    @Unroll("Input: #n")
    def "superTest"() {
        when:"input is 28"
        then: "result will be a collection with the element 2"
        generator.generate(n).every({x -> isPrime(x)})
        //generator.generate(n).findAll {x -> !isPrime(x)}.size() == 0 // Are equivalent
        //generator.generate(n).count {x -> !isPrime(x)} == 0// Are equivalent
        where:
        n << IntStream.iterate(2, { n -> n + 1}).limit(1000)
    }


    def isPrime(Integer number){
        for(def i = 2; i < number - 1; i++){
            if(number % i == 0){
                return false
            }
        }
        return true
    }
}
