package com.example.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}