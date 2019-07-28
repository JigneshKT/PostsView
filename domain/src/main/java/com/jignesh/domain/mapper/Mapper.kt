package com.jignesh.domain.mapper

interface Mapper<out V, in D,R> {
    fun mapIt(type: D, type2:R): V
}