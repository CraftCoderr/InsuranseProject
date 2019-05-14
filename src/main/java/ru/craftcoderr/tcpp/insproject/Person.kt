package ru.craftcoderr.tcpp.insproject

import java.io.Serializable

data class Person(val name: String, val gender: GenderType, val age: Int, val sport: Boolean) : Serializable