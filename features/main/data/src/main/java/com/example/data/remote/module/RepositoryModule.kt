package com.example.data.remote.module

import com.example.data.remote.repository.WeatherRepositoryImpl
import com.example.domain.repository.WeatherRepository
import org.koin.dsl.module

val repoModule = module {
    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
}