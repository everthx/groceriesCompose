package com.example.groceriescompose.common

interface Mapper<I, O> {
    fun map(input: I): O
}