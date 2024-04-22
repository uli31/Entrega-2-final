package com.example.entregafinal

data class Car(
    val id: Int,
    val marca: String,
    val modelo: String,
    val año: Int,
    val color: String,
    val precio: Double,
    val detalles: CarDetails
)

data class CarDetails(
    val motor: String,
    val transmisión: String,
    val tracción: String,
    val kilometraje: Int
)
