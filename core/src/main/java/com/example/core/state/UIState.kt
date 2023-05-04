package com.example.core.state

sealed class UIState<T> {
    class Idle<T> : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
    class Loading<T>() : UIState<T>()
    class Error<T>(val msg: String) : UIState<T>()
}
