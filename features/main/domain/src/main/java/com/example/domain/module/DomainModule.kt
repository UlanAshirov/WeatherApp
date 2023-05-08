package com.example.domain.module

import com.example.domain.usecases.GetForecastWeatherUseCase
import com.example.domain.usecases.GetLocationUseCase
import com.example.domain.usecases.GetWeatherUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetWeatherUseCase(get()) }
    factory { GetForecastWeatherUseCase(get()) }
    factory { GetLocationUseCase(get()) }
}