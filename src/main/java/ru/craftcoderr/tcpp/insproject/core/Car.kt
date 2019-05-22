package ru.craftcoderr.tcpp.insproject.core

import java.io.Serializable

data class Car(val model: String, val year: Int, val regNumber: String, val power: Int, val vin: String) : Serializable