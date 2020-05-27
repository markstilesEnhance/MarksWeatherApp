package com.example.marksweatherapp.model.classes

data class MyDate(
    val date: String
): DetailData() {
    override val type = 2
}